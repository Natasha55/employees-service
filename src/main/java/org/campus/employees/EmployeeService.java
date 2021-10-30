package org.campus.employees;

public class EmployeeService {

    Employee[] employees;

    public EmployeeService(Employee[] employees) {
        this.employees = employees;
    }

    public void printEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.print("id " + employee.id);
                System.out.print(", name " + employee.name);
                System.out.print(", age " + employee.age);
                System.out.print(", salary " + employee.salary);
                System.out.print(", gender " + employee.gender);
                System.out.print(", fixedBugs " + employee.fixedBugs);
                System.out.println(", defaultBugRate " + employee.defaultBugRate + ".");
            }
        }
    }

    double calculateSalaryAndBonus() {
        double totalSalaryMonth = 0.0;
        for (Employee employee : employees) {
            employee.countSalaryAndBonus();
            totalSalaryMonth += employee.totalSalary;
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

    public Employee[] sortByNameAndSalary() {
        for (int i = 0; i < employees.length; i++) {
            for (int j = i + 1; j < employees.length; j++) {
                if ((employees[i].name.compareTo(employees[j].name) > 0) && (employees[i].salary > employees[j].salary)) {
                    Employee buf = employees[i];
                    employees[i] = employees[j];
                    employees[j] = buf;
                }
            }
            ;
        }
        return employees;
    }

    public Employee edit(Employee employee) {
        for (int i = 0; i < employees.length; i++)
            if (employees[i].id == employee.id) {
                employees[i] = new EmployeeFactory().generateEmployees(1)[0];
            }
        return employee;
    }
}

