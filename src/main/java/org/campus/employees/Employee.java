package org.campus.employees;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Employee {

    long id;
    String name;
    int age;
    String gender;
    double salary;


    double totalSalary;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
