package org.example;

public class Bookstore {
    private String name;
    private int booksCount;
    private int employees;

    private static int totalStores = 0;
    private static int totalBooks = 0;

    public Bookstore(String name, int booksCount, int employees) {
        this.name = name;
        this.booksCount = booksCount;
        this.employees = employees;
        totalStores++;
        totalBooks += booksCount;
    }

    public String getName() {
        return name;
    }

    public int getBooksCount() {
        return booksCount;
    }

    public int getEmployees() {
        return employees;
    }

    public static int getTotalStores() {
        return totalStores;
    }

    public static int getTotalBooks() {
        return totalBooks;
    }

    public static double getAverageBooks() {
        if (totalStores == 0) {
            return 0.0;
        }
        return (double) totalBooks / totalStores;
    }
}
