package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudyManager {
    List<StudyTask> tasks = new ArrayList<>();
    int nextId = 1;

    void addExercise(String title) {
        if (title.trim().isEmpty()) {
            System.out.println("Nie dozwolony");
            return;
        }
        tasks.add(new StudyTask(nextId, title));
        nextId++;
    }

    void deleteExercise(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                return;
            }
        }
        System.out.println("Podane id nie istnieje");
    }

    void exerciseStatus(int id) {
        for (StudyTask task : tasks) {
            if (task.getId() == id) {
                if (task.isCompleted()) {
                    System.out.println("Zadanie ukończone");
                } else {
                    task.markCompleted();
                    System.out.println("Zadanie oznaczono jako ukończone");
                }
                return;
            }
        }
        System.out.println("Podane id nie istnieje");
    }

    void showExercise(String filter) {
        for (StudyTask task : tasks) {
            switch (filter) {
                case "all" -> System.out.printf("Numer zadania:%d%n Nazwa zadania:%s%n Status zadania:%s%n "
                        , task.getId(), task.getTitle(), task.isCompleted());
                case "active" -> {
                    if (!task.isCompleted()) {
                        System.out.printf("Numer zadania:%d%n Nazwa zadania:%s%n Status zadania:%s%n "
                                , task.getId(), task.getTitle(), task.isCompleted());
                    }
                }
                case "completed" -> {
                    if (task.isCompleted()) {
                        System.out.printf("Numer zadania:%d%n Nazwa zadania:%s%n Status zadania:%s%n "
                                , task.getId(), task.getTitle(), task.isCompleted());

                    }
                }
            }
        }
    }

    void handleAddExercise(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Podaj tytuł: ");
        String title = scanner.nextLine();
        addExercise(title);
    }

    void markAsCompleted(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Które zadanie zostało ukończone?");
        int id = onlyInt(scanner);
        exerciseStatus(id);
    }

    void handleDeleteExercise(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Które zadanie usunąć?");
        int id = onlyInt(scanner);
        deleteExercise(id);
    }

    void showFilteredEx(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Jakie zadanie wyswietlic? all, active czy completed ");
        String filter = scanner.next();
        if (filter.equals("all") || filter.equals("active") || filter.equals("completed")) {
            showExercise(filter);
        } else {
            System.out.println("Błędny filtr");
        }
    }

    static int onlyInt(Scanner scanner) {
        while(!scanner.hasNextInt()) {
            System.out.println("Wymagana liczba, błędny typ!");
            scanner.next();
        }

        return scanner.nextInt();
    }
}
