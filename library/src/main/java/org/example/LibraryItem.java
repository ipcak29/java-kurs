package org.example;

public abstract class LibraryItem {
    protected final String title;
    protected boolean borrowed;

    public LibraryItem(String title, boolean borrowed) {
        this.title = title;
        this.borrowed = borrowed;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public String toString() {
        return title;
    }

    public void borrow() {
        if (borrowed) {
            System.out.println("Element jest wypozyczony");
            return;
        }
        System.out.printf("Wypozyczono %s%n", title);
        borrowed = true;
    }

    public void returnItem() {
        if (!borrowed) {
            System.out.println("Tytul dostepny");
            return;
        }
        System.out.printf("Zwrócono %s%n", title);
        borrowed = false;
    }
}