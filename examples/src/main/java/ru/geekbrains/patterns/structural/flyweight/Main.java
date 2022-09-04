package ru.geekbrains.patterns.structural.flyweight;

public class Main {
    public static void main(String[] args) {
        TeaMaker teaMaker = new TeaMaker();
        TeaShop teaShop = new TeaShop(teaMaker);
        teaShop.takeOrder(1, 2);
        teaShop.takeOrder(4, 3);
        teaShop.takeOrder(15, 5);
    }
}
