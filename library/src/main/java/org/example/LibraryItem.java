package org.example;

public abstract class LibraryItem {
    private final String title;
    private boolean borrowed;

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

    public String displayInfo() {
        return title;
    }

    public void borrow(String title) {
        if (borrowed) {
            System.out.println("Element jest wypozyczony");
            return;
        }
        System.out.printf("Wypozyczono %s%n", title);
        borrowed = true;
    }

    public void availableItem(String title) {
        if(!borrowed){
            System.out.println("Tytul dostepny");
            return;
        }
        System.out.printf("Zwrócono %s%n", title);
        borrowed = false;
    }
}

