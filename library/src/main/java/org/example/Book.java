package org.example;

public class Book extends LibraryItem {
    private final String author;
    private final int pages;
    private static int totalBooks;

    public Book(String title, String author, boolean borrowed, int pages) {
        super(title, borrowed);
        this.author = author;
        this.pages = pages;
        totalBooks++;
    }

    @Override
    public String displayInfo() {
        return "Książka " + getTitle()
                + "autor: " + author
                + "strony: " + pages
                + " status: " + (isBorrowed() ? "wypożyczona " : "dostępna");
    }
    public static int getTotalBooks(){
        return totalBooks;
    }
}
