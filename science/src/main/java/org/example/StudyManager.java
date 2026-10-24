package org.example;

import java.util.ArrayList;
import java.util.List;

public class StudyManager {
List<StudyTask> tasks = new ArrayList<>();
int nextId = 1;

void addExercise(String title){
tasks.add(new StudyTask(nextId, title));
nextId++;
}

void deleteExercise(int id){
    for (int i = 0; i < tasks.size(); i++) {
        if(tasks.get(i).getId() == id){
            tasks.remove(i);
            return;
        }
    }
}
}
