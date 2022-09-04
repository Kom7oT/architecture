package ru.geekbrains.domain;

import java.util.Map;

public final class HttpRequest {

    private String method;

    private String url;

    private Map<String, String> headers;

    private String body;

    private HttpRequest() {
    }

    public HttpRequest(String method, String url, Map<String, String> headers, String body) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.body = body;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }
    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder {

        private final HttpRequest httpRequest = new HttpRequest();

        public Builder withMethod(String method) {
            this.httpRequest.method = method;
            return this;
        }

        public Builder withUrl(String url) {
            this.httpRequest.url = url;
            return this;
        }

        public Builder withHeader(String key, String value) {
            this.httpRequest.getHeaders().put(key, value);
            return this;
        }

        public Builder withBody(String body) {
            this.httpRequest.body = body;
            return this;
        }

        public HttpRequest build() {
            if (this.httpRequest.getMethod() == null) {
                throw new IllegalStateException("method not defined!");
            }

            if (this.httpRequest.getUrl() == null) {
                throw new IllegalStateException("URL not defined!");
            }
            return this.httpRequest;
        }
    }
}
