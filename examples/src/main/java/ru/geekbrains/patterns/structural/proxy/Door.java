package ru.geekbrains.patterns.structural.proxy;

public interface Door {
    void open();

    void open(String password);

    void close();
}
