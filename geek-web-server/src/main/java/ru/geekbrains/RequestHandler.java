package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;

import java.io.IOException;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final SocketService socketService;

    private final FileService fileService;

    private final RequestParser requestParser;

    private final ResponseSerializer responseSerializer;

    public RequestHandler(SocketService socketService,
                          FileService fileService,
                          RequestParser requestParser,
                          ResponseSerializer responseSerializer) {
        this.socketService = socketService;
        this.fileService = fileService;
        this.requestParser = requestParser;
        this.responseSerializer = responseSerializer;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest request = requestParser.parse(rawRequest);

        if (!fileService.exists(request.getUrl())) {
            HttpResponse response = HttpResponse.createBuilder()
                    .withStatusCode(404)
                    .withStatusCodeName("NOT_FOUND")
                    .withHeader("Content-Type", "text/html; charset=utf-8")
                    .build();
            socketService.writeResponse(responseSerializer.serialize(response));
            return;
        }

        HttpResponse response = HttpResponse.createBuilder()
                .withStatusCode(200)
                .withStatusCodeName("OK")
                .withHeader("Content-Type", "text/html; charset=utf-8")
                .withBody(fileService.readFile(request.getUrl()))
                .build();
        socketService.writeResponse(responseSerializer.serialize(response));

        try {
            socketService.close();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        System.out.println("Client disconnected!");
    }
}
