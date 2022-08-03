package org.campus.employees;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    Employee[] employees;

    public EmployeeService(Employee[] employees) {
        this.employees = employees;
    }

    void printEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.print("id " + employee.id);
                System.out.print(", " + employee.getClass().getSimpleName());
                System.out.print(", name " + employee.name);
                System.out.print(", age " + employee.age);
                System.out.print(", salary " + employee.salary);
                System.out.println(", gender " + employee.gender);

                if (employee instanceof Designer) {
                    Designer designer = (Designer) employee;
                    System.out.print("and rate " + designer.rate);
                    System.out.println(", worked days " + designer.workedDays);
                }

                if (employee instanceof Developer) {
                    Developer developer = (Developer) employee;
                    System.out.print("and fixed bugs " + developer.fixedBugs);
                }
            }
        }
    }

    double calculateSalaryAndBonus() {
        logger.info("start to calculate salary and bonus.");

        double totalSalaryMonth = 0.0;
        for (Employee employee : employees) {
            if (employee instanceof Designer) {
                Designer designer = (Designer) employee;
                double totalSalary = designer.salary + designer.rate * designer.workedDays;
                totalSalaryMonth += totalSalary;

                logger.info("employee is DESIGNER  salary: " + designer.salary
                        + " + rate: " + designer.rate
                        + " + worked days: " + designer.workedDays
                        + " = " + totalSalary + ". total month salary: " + totalSalaryMonth);
            }
            if (employee instanceof Developer) {
                Developer developer = (Developer) employee;
                double totalSalary = (developer.salary + developer.fixedBugs * 0.05) * (developer.randomBoolean ? 2 : 0);
                totalSalaryMonth += totalSalary;
                logger.info("employee is DEVELOPER salary: " + totalSalary + ". total month salary: " + totalSalaryMonth);
            }
            if (employee instanceof Manager) {
                Manager manager = (Manager) employee;
                double totalSalary = manager.salary;
                totalSalaryMonth += totalSalary;
                logger.info("employee is MANAGER   salary: {} total month salary: {}", totalSalary, totalSalaryMonth);
            }
        }
        return totalSalaryMonth;
    }

    public Employee getById(long id) {
        for (Employee employee : employees) {
            if (employee.id == id) {
                return employee;
            }
        }

        throw new IllegalStateException("Can't find employee with id: " + id);
    }

    public Employee getByName(String name) {
        for (Employee employee : employees) {
            if (employee.name.equals(name)) {
                return employee;
            }
        }
        throw new IllegalStateException("Can't find employee with name: " + name);
    }

    Employee removeById(long id) {

        Employee employee = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].id == id) {
                employee = employees[i];
                employees[i] = null;

            }
        }
        logger.info("delete employee with id {}", id);
        return employee;
    }

    public void sortByName() {

        for (int i = 0; i < employees.length - 1; i++) {
            for (int j = employees.length - 1; j > i; j--) {
                if (employees[j - 1].name.compareTo(employees[j].name) > 0) {
                    Employee buf = employees[j - 1];
                    employees[j - 1] = employees[j];
                    employees[j] = buf;
                }
            }
        }
    }


    public Employee edit(Employee employee) {
        for (int i = 0; i < employees.length; i++)
            if (employees[i].id == employee.id) {
                employees[i] = new EmployeeFactory().getRandomEmployees(1)[0];
            }
        logger.info("edit info about employee: {}", employee.id);
        return employee;
    }

    public void add(Employee employee) {
        Employee[] employeesAfterAdd = new Employee[this.employees.length + 1];
        System.arraycopy(this.employees, 0, employeesAfterAdd, 0, this.employees.length);
        employeesAfterAdd[employeesAfterAdd.length - 1] = employee;
        this.employees = employeesAfterAdd;
        logger.info("add new employee {}", employeesAfterAdd);

    }
}
