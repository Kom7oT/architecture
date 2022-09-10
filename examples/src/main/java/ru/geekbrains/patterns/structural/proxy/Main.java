package ru.geekbrains.patterns.structural.proxy;

public class Main {
    public static void main(String[] args) {
        Door door = new SecuredDoor(new LabDoor());
        {
            door.open("invalid");
            door.open("secret");
            door.close();
        }
    }
}
