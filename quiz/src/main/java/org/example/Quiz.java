package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Quiz {
    private final int[] results;

    public Quiz(int[] results) {
        this.results = results;
    }

    public int sum() {
        int sum = 0;
        for (int result : results) {
            sum += result;
        }
        return sum;
    }

    public double average() {
        double average;
        average = (double) sum() / results.length;
        return average;
    }

    public int countPassed() {
        int passed = 0;
        for (int result : results) {
            if (result >= 50) {
                passed++;
            }
        }
        return passed;
    }

    public int min() {
        int min = results[0];
        for (int result : results) {
            if (result < min) {
                min = result;
            }
        }
        return min;
    }

    public int max() {
        int max = results[0];
        for (int result : results) {
            if (result > max) {
                max = result;
            }
        }
        return max;
    }

    public Set<Integer> uniqueValues() {
        Set<Integer> unique = new HashSet<>();
        for (int result : results) {
            unique.add(result);
        }
        return unique;
    }

    public Map<Integer, Integer> frequencies() {
        Map<Integer, Integer> frequent = new HashMap<>();
        for (int result : results) {
            int count = frequent.getOrDefault(result, 0);
            frequent.put(result, count + 1);
        }
        return frequent;
    }

    public int getParticipantCount() {
        return results.length;
    }

    public int countInRange(int min, int max) {
        int count = 0;
        for (int result : results) {
            if (result >= min && result <= max) {
                count++;
            }
        }
        return count;
    }

    public void changeScore(int participantNumber, int newScore) {
        results[participantNumber - 1] = newScore;
    }

    public int getScore(int participantNumber) {
        return results[participantNumber - 1];
    }
}
