package ru.geekbrains.patterns.structural.adapter;

public class WildDogAdapter implements Lion {

    protected WildDog dog;

    public WildDogAdapter(WildDog dog) {
        this.dog = dog;
    }

    public String roar(){
       return dog.bark();
    }

    Hunter hunter = new Hunter();

}
