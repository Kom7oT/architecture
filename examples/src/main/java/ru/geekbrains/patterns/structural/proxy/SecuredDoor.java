package ru.geekbrains.patterns.structural.proxy;

public class SecuredDoor implements Door{

    protected Door door;

    public SecuredDoor(Door door) {
        this.door = door;
    }
    @Override
    public void open() {
    }
@Override
    public void open(String password) {
        if (authenticate(password)) {
            door.open();
        } else {
            System.out.println("Access Denied!!!");
        }
    }

    public boolean authenticate(String password) {
        return password.equals("secret");
    }



    public void close() {
        door.close();
    }
}
