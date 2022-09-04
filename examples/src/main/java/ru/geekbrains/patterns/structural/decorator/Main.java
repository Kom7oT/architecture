package ru.geekbrains.patterns.structural.decorator;

public class Main {
    public static void main(String[] args) {

        Coffee someCoffee = new SimpleCoffee();
        System.out.println(someCoffee.getDescription());
        System.out.println(someCoffee.getCost());

        Coffee anotherSomeCoffee  = new WhipCoffee(someCoffee);
        System.out.println(anotherSomeCoffee.getDescription());
        System.out.println(anotherSomeCoffee.getCost());

        Coffee anotherSomeCoffee1 = new MilkCoffee(anotherSomeCoffee);
        System.out.println(anotherSomeCoffee1.getDescription());
        System.out.println(anotherSomeCoffee1.getCost());
    }
}
