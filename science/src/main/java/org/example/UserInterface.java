package org.example;

import java.util.Scanner;

public class UserInterface {
    private final StudyManager studyManager = new StudyManager();

    private int onlyInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Wymagana liczba, błędny typ!");
            scanner.next();
        }

        return scanner.nextInt();
    }

    private void handleAddExercise(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Podaj tytuł: ");
        String title = scanner.nextLine();
        studyManager.addExercise(title);
    }

    private void handleDeleteExercise(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Które zadanie usunąć? podaj id");
        int id = onlyInt(scanner);
        studyManager.deleteExercise(id);
    }

    private void handleAddTag(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Podaj id: ");
        int id = onlyInt(scanner);
        scanner.nextLine();

        System.out.println("Podaj tag: ");
        String tag = scanner.nextLine();
        studyManager.addTagToEx(id, tag);
    }

    private void handleRemoveTag(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Podaj id: ");
        int id = onlyInt(scanner);
        scanner.nextLine();

        System.out.println("Podaj tag: ");
        String tag = scanner.nextLine();
        studyManager.removeTagFromEx(id, tag);
    }

    private void handleFindByTag(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Podaj tag: ");
        String tag = scanner.nextLine();
        studyManager.findByTag(tag);
    }

    private void markAsCompleted(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Które zadanie zostało ukończone? podaj id");
        int id = onlyInt(scanner);
        studyManager.markAsCompleted(id);
    }

    private void showFilteredEx(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Jakie zadanie wyswietlic? all, active czy completed ");
        String filter = scanner.next();
        if (filter.equals("all") || filter.equals("active") || filter.equals("completed")) {
            for (StudyTask task : studyManager.getExercises(filter)){
                System.out.println(task);
            }
        } else {
            System.out.println("Błędny filtr");
        }
    }

    private void showUsedTags() {
        System.out.println(studyManager.getUsedTags());
    }

    private void showTagCounts() {
        System.out.println(studyManager.getTagCounts());
    }

    private void showMenu() {
        System.out.println("""
                1.Dodaj zadanie
                2. Pokaż zadania i wybierz filtr
                3. Oznacz jako ukończone
                4. Usuń zadanie
                5. Dodaj tag
                6. Usuń tag
                7. Znajdź po tagu
                8. Pokaż wszystkie użyte tagi
                9. Pokaż ilość użytych tagów
                0. Wyjście
                """);
    }

    public void startMenu(Scanner scanner) {
        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = onlyInt(scanner);
            switch (choice) {
                case 1 -> handleAddExercise(scanner);
                case 2 -> showFilteredEx(scanner);
                case 3 -> markAsCompleted(scanner);
                case 4 -> handleDeleteExercise(scanner);
                case 5 -> handleAddTag(scanner);
                case 6 -> handleRemoveTag(scanner);
                case 7 -> handleFindByTag(scanner);
                case 8 -> showUsedTags();
                case 9 -> showTagCounts();
                default -> System.out.println("Błędna opcja, spróbuj ponownie");
            }
        }
    }
}
