package ru.geekbrains.patterns.structural.composite.employee;

import java.lang.reflect.Array;

public class Designer implements Employee{

    protected float salary;
    protected String name;
    protected Array[] roles;

    public Designer(float salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float setSalary() {
        return this.salary = salary;
    }

    @Override
    public float getSalary() {
        return this.salary;
    }

    @Override
    public Array[] getRoles() {
        return this.roles;
    }
}
