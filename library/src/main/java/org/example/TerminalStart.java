package org.example;

import java.util.Scanner;

public class TerminalStart {
    Scanner scanner = new Scanner(System.in);
    LibraryService libraryService;

    public TerminalStart(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void showBorrowedItems() {
        LibraryItem[] result = libraryService.listItems(true);
        for (LibraryItem item : result) {
            if (item != null) {
                System.out.println(item.displayInfo());
            }
        }
    }

    public void showAvailableItems() {
        LibraryItem[] result = libraryService.listItems(false);
        for (LibraryItem item : result) {
            if (item != null) {
                System.out.println(item.displayInfo());
            }
        }
    }

    public void processReturnItem() {
        System.out.println("Podaj tytuł: "); ///zrobic to

    }

    public void processBorrowItem() { //// i to zrobic

    }

    public void start() {
        int choice = 0;
        while (choice != 7) {
            System.out.println("Menu główne");
            System.out.println("1.Wyswietl liste dostepnych: ");
            System.out.println("2.Wyswietl liste wypożyczonych: ");
            System.out.println("3.Wypozycz element po tytule ");
            System.out.println("4.Zwróć element po tytule ");
            System.out.println("5.Wyświetl liczbe książek w systemie: ");
            System.out.println("6. Wyswietl liczbe filmów w systemie: ");
            System.out.println("7. Wyjście z programu ");
            System.out.println("Wpisz numer: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showAvailableItems();
                case 2 -> showBorrowedItems();
                case 3 -> processBorrowItem();
                case 4 -> processReturnItem();
                case 5 -> System.out.println("Książki w systemie: " + Book.getTotalBooks());
                case 6 -> System.out.println("Filmy w systemie: " + Movie.getTotalMovies());
                case 7 -> System.out.println("Koniec programu papa");
            }
        }
    }
}

