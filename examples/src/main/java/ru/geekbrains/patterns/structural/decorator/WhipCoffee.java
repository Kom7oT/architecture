package ru.geekbrains.patterns.structural.decorator;

public class WhipCoffee implements Coffee {

    protected Coffee coffee;

    public WhipCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public float getCost() {
        return this.coffee.getCost() + 5;
    }

    public String getDescription() {
        return this.coffee.getDescription() + " whip ";
    }
}
