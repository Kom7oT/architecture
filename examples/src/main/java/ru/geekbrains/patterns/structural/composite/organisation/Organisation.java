package ru.geekbrains.patterns.structural.composite.organisation;

import ru.geekbrains.patterns.structural.composite.employee.Employee;

public class Organisation {
    protected Employee[] employees;

    public Employee[] addEmployee(Employee[] employee) {
        return this.employees = employee;
    }

    public float getSalaries() {
        float salary = 0;
        int i;
        for (i = 0; i < employees.length; i++) {
            salary += employees[i].getSalary();
        }
        return salary;
    }
}

