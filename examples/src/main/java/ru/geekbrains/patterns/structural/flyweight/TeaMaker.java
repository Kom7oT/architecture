package ru.geekbrains.patterns.structural.flyweight;

import java.lang.reflect.Array;

public class TeaMaker {

    protected String[] availableTea;

    public String make(int preference){
        if (this.availableTea==null){
            this.availableTea[preference] = String.valueOf(new KarakTea());
        }
        return this.availableTea[preference];
    }
}
