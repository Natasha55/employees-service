package org.campus.employees;

public class Employee {

    long id;
    String name;
    int age;
    double salary;
    String gender;
    int fixedBugs;
    int defaultBugRate;
    double totalSalary;

    public Employee() {
    }


    public double countSalaryAndBonus() {
        double payFixedBugs = fixedBugs * 0.02;
        double payDefaultBugRate = (defaultBugRate >= 12 ? (0) : (salary * (0.05)));
        totalSalary = salary + payFixedBugs + payDefaultBugRate;
        return totalSalary;
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
