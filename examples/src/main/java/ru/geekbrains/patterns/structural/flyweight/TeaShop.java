package ru.geekbrains.patterns.structural.flyweight;

public class TeaShop {

    protected String[] orders;
    protected TeaMaker teaMaker;

    public TeaShop(TeaMaker teaMaker) {
        this.teaMaker = teaMaker;
    }

    public String takeOrder(int teaType, int table) {
        return this.orders[table] = this.teaMaker.make(teaType);
    }

    public void serve() {
        for (String table : this.orders) {
            System.out.println("Serving tea to table " + table);
        }
    }
}

