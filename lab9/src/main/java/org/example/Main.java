package org.example;

public class Main {
    public static void main(String[] args) {
        Literature[] books = new Literature[5];

        books[0] = new Novel("Мастер и Маргарита", "М. А. Булгаков", 480, "Мистический роман");
        books[1] = new Novel("Преступление и наказание", "Ф. М. Достоевский", 672, "Социально-психологический роман");
        books[2] = new Novel("Дюна", "Фрэнк Герберт", 704, "Научная фантастика");

        books[3] = new Textbook("Философия Java", "Брюс Эккель", 1168, "Программирование");
        books[4] = new Textbook("Высшая математика", "В. С. Шипачев", 479, "Математика");

        for (Literature book : books) {
            book.displayInfo();
            System.out.println("Жанр (тип издания): " + book.getGenre());
            System.out.println("Описание: " + book.getSummary());
            System.out.println();
        }
    }
}
