package org.example;

public class Novel extends Literature {
    private String genre;

    public Novel(String title, String author, int pages, String genre) {
        super(title, author, pages);
        this.genre = genre;
    }

    public String getNovelGenre() {
        return genre;
    }

    public void setNovelGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String getGenre() {
        return "Роман";
    }

    @Override
    public String getSummary() {
        return "Краткое содержание романа";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Поджанр романа: " + genre);
    }
}
