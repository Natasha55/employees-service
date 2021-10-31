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


    Designer[] generateDesigners (int size) {
        Random random = new Random();
        Designer[] designers = new Designer[size];
        for (int i = 0; i < size; i++) {
            Designer designer = new Designer();
            designer.id = ++autoIncrement;
            String[] arrayGender = new String[]{"male", "female", "neutral", "null-gender"};
            designer.gender = arrayGender[random.nextInt(4)];
            //name
            if (designer.gender.equals("male") |
                    designer.gender.equals("neutral")) {
                designer.name = manName[random.nextInt(5)];
            }
            if (designer.gender.equals("female") |
                    designer.gender.equals("null-gender")) {
                designer.name = womanName[random.nextInt(5)];
            }
            designer.age = 18 + random.nextInt(55);
            designer.salary = 2500 + random.nextInt(32000);
            designer.rate = random.nextDouble();
            designer.workedDays = 12 + random.nextInt(24);
            designers[i] = designer;
            }
        return designers;
    }

    Manager[] generateManagers (int size) {
        Random random = new Random();
        Manager[] managers = new Manager[size];
        for (int i = 0; i < size; i++) {
            Manager manager = new Manager();
            manager.id = ++autoIncrement;
            String[] arrayGender = new String[]{"male", "female", "neutral", "null-gender"};
            manager.gender = arrayGender[random.nextInt(4)];
            //name
            if (manager.gender.equals("male") |
                    manager.gender.equals("neutral")) {
                manager.name = manName[random.nextInt(5)];
            }
            if (manager.gender.equals("female") |
                    manager.gender.equals("null-gender")) {
                manager.name = womanName[random.nextInt(5)];
            }
            manager.age = 18 + random.nextInt(55);
            manager.salary = 2500 + random.nextInt(32000);
            managers[i] = manager;
        }
        return managers;
    }

    Developer[] generateDevelopers (int size) {
        Random random = new Random();
        Developer[] developers = new Developer[size];
        for (int i = 0; i < size; i++) {
            Developer developer = new Developer();
            developer.id = ++autoIncrement;
            String[] arrayGender = new String[]{"male", "female", "neutral", "null-gender"};
            developer.gender = arrayGender[random.nextInt(4)];
            //name
            if (developer.gender.equals("male") |
                    developer.gender.equals("neutral")) {
                developer.name = manName[random.nextInt(5)];
            }
            if (developer.gender.equals("female") |
                    developer.gender.equals("null-gender")) {
                developer.name = womanName[random.nextInt(5)];
            }
            developer.age = 18 + random.nextInt(55);
            developer.salary = 2500 + random.nextInt(32000);
            developer.fixedBugs = random.nextInt(10);
            developer.randomBoolean = random.nextBoolean();
            developers[i] = developer;
        }
        return developers;
    }


    Employee[] getRandomEmployees(int size) {
        Random random = new Random();
        int designersCount = random.nextInt(size);
        int managersCount = random.nextInt(size - designersCount);
        int developersCount  = size - designersCount - managersCount;

        Designer[] designers = generateDesigners(designersCount);
        Manager[] managers = generateManagers(developersCount);
        Developer[] developers = generateDevelopers(managersCount);

        Employee[] employees = new Employee[size];
        int index = 0;

        for (Designer designer : designers) {
            employees[index] = designer;
            index++;
        }
        for (Manager manager : managers) {
            employees[index] = manager;
            index++;
        }
        for (Developer developer : developers) {
            employees[index] = developer;
            index++;
        }
        return employees;
    }

    }
