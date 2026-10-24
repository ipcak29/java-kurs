package org.example;

import java.util.ArrayList;
import java.util.List;

public class StudyManager {
    List<StudyTask> tasks = new ArrayList<>();
    int nextId = 1;

    void addExercise(String title) {
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
    }

    void exerciseStatus(int id) {
        for (StudyTask task : tasks) {
            if (task.getId() == id) {
                task.markCompleted();
                return;
            }
        }
    }

    void showExercise(String filter) {
        for (StudyTask task : tasks) {
            switch (filter) {
                case "all" -> System.out.printf("Numer zadania:%d%n Nazwa zadania:%s%n Status zadania:%s%n ",task.getId(), task.getTitle(), task.isCompleted());
                case "active" -> {
                    if (!task.isCompleted()) {
                        System.out.printf("Numer zadania:%d%n Nazwa zadania:%s%n Status zadania:%s%n ",task.getId(), task.getTitle(), task.isCompleted());
                    }
                }
                case "completed" -> {
                    if (task.isCompleted()) {
                        System.out.printf("Numer zadania:%d%n Nazwa zadania:%s%n Status zadania:%s%n ",task.getId(), task.getTitle(), task.isCompleted());

                    }
                }
            }
        }
    }
}
