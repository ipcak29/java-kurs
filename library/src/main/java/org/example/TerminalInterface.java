package org.example;

import java.util.Scanner;

public class TerminalInterface {
    Scanner scanner = new Scanner(System.in);
    LibraryService libraryService;

    public TerminalInterface(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void showItems(boolean borrowed) {
        LibraryItem[] result = libraryService.listItems(borrowed);
        for (LibraryItem item : result) {
            if (item != null) {
                System.out.println(item.displayInfo());
            }
        }
    }

    public void processReturnItem() {
        showItems(true);
        System.out.println("Podaj tytuł do zwrotu: ");
        String title = scanner.nextLine();
        libraryService.returnItem(title);
    }

    public void processBorrowItem() {
        showItems(false);
        System.out.println("Podaj tytuł do wypożyczenia: ");
        String title = scanner.nextLine();
        libraryService.borrowItem(title);
    }

    public void start() {
        int choice = 0;
        System.out.println("Menu główne");
        System.out.println("1.Wyswietl liste dostepnych: ");
        System.out.println("2.Wyswietl liste wypożyczonych: ");
        System.out.println("3.Wypozycz element po tytule ");
        System.out.println("4.Zwróć element po tytule ");
        System.out.println("5.Wyświetl liczbe książek w systemie: ");
        System.out.println("6. Wyswietl liczbe filmów w systemie: ");
        System.out.println("7. Wyjście z programu ");
        while (choice != 7) {
            System.out.println("Wpisz numer: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showItems(false);
                case 2 -> showItems(true);
                case 3 -> processBorrowItem();
                case 4 -> processReturnItem();
                case 5 -> System.out.println("Książki w systemie: " + Book.getTotalBooks());
                case 6 -> System.out.println("Filmy w systemie: " + Movie.getTotalMovies());
                case 7 -> System.out.println("Koniec programu papa");
            }
        }
    }
}

