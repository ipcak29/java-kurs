package org.example;

import java.util.*;

public class StudyManager {
    private final List<StudyTask> tasks = new ArrayList<>();
    private int nextId = 1;

    public void addExercise(String title) {
        if (title.trim().isEmpty()) {
            System.out.println("Nie dozwolony");
            return;
        }
        tasks.add(new StudyTask(nextId, title));
        nextId++;
    }

    public void deleteExercise(int id) {
        StudyTask task = findById(id);
        if (task == null) {
            System.out.println("Podane id nie istnieje");
            return;
        }
        tasks.remove(task);
    }

    public void markAsCompleted(int id) {
        StudyTask task = findById(id);
        if (task == null) {
            System.out.println("Podane id nie istnieje");
            return;
        }
        if (task.isCompleted()) {
            System.out.println("Zadanie ukończone");
            return;
        }
        task.markCompleted();
    }

    public List<StudyTask> getExercises(String filter) {
        List<StudyTask> filteredTasks = new ArrayList<>();

        for (StudyTask task : tasks) {
            if (shouldShow(task, filter)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    private boolean shouldShow(StudyTask task, String filter) {
        return switch (filter) {
            case "all" -> true;
            case "active" -> !task.isCompleted();
            case "completed" -> task.isCompleted();
            default -> false;
        };
    }

    public void addTagToEx(int id, String tag) {
        StudyTask task = findById(id);
        if (task == null) {
            System.out.println("Podano nieistniejące id");
            return;
        }
        task.addTag(tag);
    }

    public void removeTagFromEx(int id, String tag) {
        StudyTask task = findById(id);
        if (task == null) {
            System.out.println("Podano nieistniejące id");
            return;
        }

        String normalTag = tag.trim().toLowerCase();

        if (!task.getTags().contains(normalTag)) {
            System.out.println("Podany tag nie istnieje");
            return;
        }
        task.removeTag(tag);
    }

    public void findByTag(String tag) {
        if (tag.trim().isEmpty()) {
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

    public Set<String> getUsedTags() {
        Set<String> usedTags = new HashSet<>();
        for (StudyTask task : tasks) {
            usedTags.addAll(task.getTags());
        }
        return usedTags;
    }

    public Map<String, Integer> getTagCounts() {
        Map<String, Integer> countTags = new HashMap<>();
        for (StudyTask task : tasks) {
            for (String tag : task.getTags()) {
                int count = countTags.getOrDefault(tag, 0);
                countTags.put(tag, count + 1);
            }
        }
        return countTags;
    }

    private StudyTask findById(long id) {
        for (StudyTask task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}