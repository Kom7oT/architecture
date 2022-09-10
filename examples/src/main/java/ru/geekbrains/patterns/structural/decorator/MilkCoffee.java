package ru.geekbrains.patterns.structural.decorator;

public class MilkCoffee implements Coffee {

    protected Coffee coffee;

    public MilkCoffee() {
    }

    public MilkCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public float getCost() {
        return this.coffee.getCost() + 2;
    }


    public String getDescription() {
        return this.coffee.getDescription() + " milk ";
    }
}
