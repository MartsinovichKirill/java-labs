package org.example;

public class Main {
    public static void main(String[] args) {
        Bookstore store1 = new Bookstore("Книжный мир", 12000, 8);
        Bookstore store2 = new Bookstore("Букинист", 4500, 3);
        Bookstore store3 = new Bookstore("Читай-Город", 25000, 15);
        Bookstore store4 = new Bookstore("Знание", 8500, 5);

        System.out.println("Магазин 1: " + store1.getName() + " | Книг: " + store1.getBooksCount() + " | Сотрудников: " + store1.getEmployees());
        System.out.println("Магазин 2: " + store2.getName() + " | Книг: " + store2.getBooksCount() + " | Сотрудников: " + store2.getEmployees());
        System.out.println("Магазин 3: " + store3.getName() + " | Книг: " + store3.getBooksCount() + " | Сотрудников: " + store3.getEmployees());
        System.out.println("Магазин 4: " + store4.getName() + " | Книг: " + store4.getBooksCount() + " | Сотрудников: " + store4.getEmployees());

        System.out.println("Всего магазинов: " + Bookstore.getTotalStores());
        System.out.println("Всего книг: " + Bookstore.getTotalBooks());
        System.out.println("Среднее число книг в магазине: " + Bookstore.getAverageBooks());
    }
}
