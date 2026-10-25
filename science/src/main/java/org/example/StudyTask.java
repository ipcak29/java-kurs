package org.example;
import java.util.HashSet;
import java.util.Set;

public class StudyTask {
    private final int id;
    private final String title;
    private boolean completed;
    private final Set<String> tags;

    public StudyTask(int id, String title) {
        this.id = id;
        this.title = title;
        this.tags = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void markCompleted() {
        completed = true;
    }

    public void addTag(String tag) {
        if (tag.trim().isEmpty()) {
            System.out.println("Nie dozwolony");
            return;
        }
        String normalTag = tag.trim().toLowerCase();
        if(!tags.add(normalTag)){
            System.out.println("Taki tag juz istnieje");
        }
    }

    public void removeTag(String tag) {
        if (tag.trim().isEmpty()) {
            System.out.println("Nie dozwolony");
            return;
        }
        String normalTag = tag.trim().toLowerCase();
        tags.remove(normalTag);
    }
}