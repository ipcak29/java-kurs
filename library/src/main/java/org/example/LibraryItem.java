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
            throw new AlreadyBorrowedException("Tytul juz jest wypożyczony ");
        }

        System.out.printf("Wypozyczono %s%n", title);
        borrowed = true;
    }

    public void returnItem() throws AlreadyReturnedException {
        if (!borrowed) {
            throw new AlreadyReturnedException("Tytul juz jest zwrocony ");
        }
        System.out.printf("Zwrócono %s%n", title);
        borrowed = false;
    }
}