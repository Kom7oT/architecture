package ru.geekbrains.patterns.structural.adapter;

public class Main {
    public static void main(String[] args) {
        WildDog dog = new WildDog();
        WildDogAdapter wildDogAdapter = new WildDogAdapter(dog);

        Hunter hunter = new Hunter();
        hunter.hunt(wildDogAdapter);
    }
}
