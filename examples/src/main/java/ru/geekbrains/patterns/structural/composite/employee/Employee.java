package ru.geekbrains.patterns.structural.composite.employee;

import java.lang.reflect.Array;

public interface Employee {
    String getName();

    float setSalary();

    float getSalary();

    Array[] getRoles();

}
