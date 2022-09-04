package ru.geekbrains.patterns.structural.decorator;

public class VanillaCoffee implements Coffee {

    public VanillaCoffee() {
    }

    protected Coffee coffee;

    public float getCost() {
        return this.coffee.getCost() + 3;
    }

    public String getDescription() {
        return this.coffee.getDescription() + " vanilla ";
    }
}
