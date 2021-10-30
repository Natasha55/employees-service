package org.campus.employees;

import java.util.Random;


public class EmployeeFactory {

    public static int autoIncrement = 0;

    public String[] getManName() {
        return manName;
    }

    public String[] getWomanName() {
        return womanName;
    }

    String[] manName = {"Viktor", "Kolya", "Petr", "Dimon", "Max"};
    String[] womanName = {"Tonya", "Alla", "Babe", "Vika", "Evgenia"};

    public Employee[] generateEmployees(int size) {
            Employee[] employees = new Employee[size];
        for(int i = 0; i < size; i++) {
            employees[i] = generateRandomEmployee();
        }
        return employees;
    }

        private Employee generateRandomEmployee() {
            Random random = new Random();
            Employee employee = new Employee();
            employee.id = ++autoIncrement;
            String[] arrayGender = new String[] {"male", "female", "neutral", "null-gender"};
            employee.gender = arrayGender[random.nextInt(4)];
            //name
            if (employee.gender.equals("male")|
                    employee.gender.equals("neutral")) {
                employee.name = manName[random.nextInt(5)];
            }
            if (employee.gender.equals("female")|
                    employee.gender.equals("null-gender")) {
                employee.name = womanName[random.nextInt(5)];
            }
            employee.age = 18 + random.nextInt( 52);
            employee.salary = 2500 + random.nextInt(52500);
            employee.fixedBugs = random.nextInt(30);
            employee.defaultBugRate = random.nextInt(26);
            return employee;
        }


        }

