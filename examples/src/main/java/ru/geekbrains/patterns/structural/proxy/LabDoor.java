package ru.geekbrains.patterns.structural.proxy;


class LabDoor implements Door {
    public void open() {
        System.out.println("Opening the lab door");
    }

    @Override
    public void open(String password) {

    }

    public void close() {
        System.out.println("Close the lab door");
    }
}
