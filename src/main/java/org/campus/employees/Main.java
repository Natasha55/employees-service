package org.campus.employees;

import org.campus.employees.EmployeeFactory;
import org.campus.employees.EmployeeService;

import java.sql.SQLOutput;


public class Main {

    public static void main(String[] args) {

        EmployeeFactory employeeFactory = new EmployeeFactory();

        EmployeeService employeeService = new EmployeeService(employeeFactory.getRandomEmployees(7));

        System.out.println("===========SERVICE==========");
        employeeService.printEmployees();



        employeeService.getById(5);
//        System.out.println("Get by id! ");

//        employeeService.getByName("Babe");
//        System.out.println("Get by Name! ");

        System.out.println("need TOTAL salary for all employees in month: " + employeeService.calculateSalaryAndBonus());

        employeeService.sortByName();
        System.out.println("After sort by Name: ");
        employeeService.printEmployees();

//        employeeService.edit(employeeService.employees[3]);
//        System.out.println("after EDIT: ");
//        employeeService.printEmployees();


        employeeService.removeById(5);
        System.out.println("after REMOVE: ");
        employeeService.printEmployees();

        employeeService.add(employeeService.employees[5]);
        System.out.println("after ADD ");
        employeeService.printEmployees();

        ;
//
//
    }

}
