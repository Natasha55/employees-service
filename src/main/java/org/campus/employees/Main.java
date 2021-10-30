package org.campus.employees;

import org.campus.employees.EmployeeFactory;
import org.campus.employees.EmployeeService;


public class Main {

    public static void main(String[] args) {

        EmployeeFactory employeeFactory = new EmployeeFactory();
//
        EmployeeService employeeService = new EmployeeService(employeeFactory.generateEmployees(10));

        System.out.println("===========SERVICE==========");
        employeeService.printEmployees();
        employeeService.getById(5);
        employeeService.getByName("Babe");

        System.out.println("TOTAL: " + employeeService.calculateSalaryAndBonus());

        employeeService.sortByName();

        employeeService.sortByNameAndSalary();


        employeeService.edit(employeeService.employees[3]);
        System.out.println("after EDIT: ");
        employeeService.printEmployees();

        employeeService.removeById(5);
        System.out.println("after REMOVE: ");
        employeeService.printEmployees();






    }

}
