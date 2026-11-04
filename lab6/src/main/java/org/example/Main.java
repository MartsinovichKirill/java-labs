package org.example;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иван", Education.BACHELOR);
        employees[1] = new Employee("Мария", Education.PHD);
        employees[2] = new Employee("Петр", Education.MASTER);
        employees[3] = new Employee("Анна", Education.PHD);
        employees[4] = new Employee("Сергей", Education.SCHOOL);

        System.out.println("Сотрудники с образованием PHD:");
        for (Employee emp : employees) {
            if (emp.getEducation() == Education.PHD) {
                System.out.println(emp.getName());
            }
        }
    }
}
