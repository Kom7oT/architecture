package ru.geekbrains.patterns.structural.decorator;

public class SimpleCoffee implements Coffee{
    public SimpleCoffee() {
    }

    public float getCost() {
        return 10;
    }

    public String getDescription() {
        return "Simple coffee ";
    }
}
