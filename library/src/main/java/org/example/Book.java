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
    public String toString() {
        return String.format("Książka: %s%n " +
                "autor: %s%n " +
                "ilość stron: %s%n" +
                " status: %b%n", title, author, pages, (borrowed ? "wypożyczony" : "dostępny"));
    }

    public static int getTotalBooks() {
        return totalBooks;
    }
}