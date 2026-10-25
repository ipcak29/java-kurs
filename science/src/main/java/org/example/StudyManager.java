package org.example;

import java.util.*;

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
                case "all" -> System.out.printf("Numer zadania:%d%n Nazwa zadania:%s%n Status zadania:%s%n Tagi: %s%n"
                        , task.getId(), task.getTitle(), task.isCompleted(), task.getTags());
                case "active" -> {
                    if (!task.isCompleted()) {
                        System.out.printf("Numer zadania:%d%n Nazwa zadania:%s%n Status zadania:%s%n Tagi: %s%n "
                                , task.getId(), task.getTitle(), task.isCompleted(), task.getTags());
                    }
                }
                case "completed" -> {
                    if (task.isCompleted()) {
                        System.out.printf("Numer zadania:%d%n Nazwa zadania:%s%nStatus zadania:%s%n Tagi: %s%n "
                                , task.getId(), task.getTitle(), task.isCompleted(), task.getTags());

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
        System.out.println("Które zadanie zostało ukończone? podaj id");
        int id = onlyInt(scanner);
        exerciseStatus(id);
    }

    void handleDeleteExercise(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Które zadanie usunąć? podaj id");
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
        while (!scanner.hasNextInt()) {
            System.out.println("Wymagana liczba, błędny typ!");
            scanner.next();
        }

        return scanner.nextInt();
    }

    void addTagToEx(int id, String tag) {
        for (StudyTask task : tasks) {
            if (task.getId() == id) {
                task.addTag(tag);
                return;
            }
        }
        System.out.println("Podano nieistniejące id");
    }

    void removeTagFromEx(int id, String tag) {
        for (StudyTask task : tasks) {
            if (task.getId() == id) {
                if (!task.getTags().contains(tag.trim().toLowerCase())) {
                    System.out.println("Podany tag nie istnieje");
                    return;
                }
                task.removeTag(tag);
                return;
            }
        }
        System.out.println("Podano nieistniejące id");
    }

    void handleAddTag(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Podaj id: ");
        int id = onlyInt(scanner);
        scanner.nextLine();

        System.out.println("Podaj tag: ");
        String tag = scanner.nextLine();
        addTagToEx(id, tag);
    }

    void handleRemoveTag(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Podaj id: ");
        int id = onlyInt(scanner);
        scanner.nextLine();

        System.out.println("Podaj tag: ");
        String tag = scanner.nextLine();
        removeTagFromEx(id, tag);
    }

    void findByTag(String tag) {
        if (tag.trim().isEmpty()){
            System.out.println("Tag nie może być pusty");
            return;
        }
        String normalTag = tag.trim().toLowerCase();
        for (StudyTask task : tasks) {
            if (task.getTags().contains(normalTag)) {
                System.out.println(task.getId() + " " + task.getTitle());
            }
        }
    }

    void handleFindByTag(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Podaj tag: ");
        String tag = scanner.nextLine();
        findByTag(tag);
    }

    static void showMenu() {
        System.out.println("""
                1.Dodaj zadanie
                2. Pokaż zadania i wybierz filtr
                3. Oznacz jako ukończone
                4. Usuń zadanie
                5. Dodaj tag
                6. Usuń tag
                7. Znajdź po tagu
                8. Pokaż wszystkie użyte tagi
                0. Wyjście
                """);
    }

    void showUsedTags() {
        HashSet<String> usedTags = new HashSet<>();
        for (StudyTask task : tasks) {
            usedTags.addAll(task.getTags());
        }
        System.out.println(usedTags);
    }
}
