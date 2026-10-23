package org.example;
import java.util.*;
import static org.example.QuizInterface.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe użytkowników ");
        int users = onlyInt(scanner);

        int[] result = getUsers(users, scanner);

        getScore(result, scanner);
        Set<Integer> unique = uniqueValues(result);
        Map<Integer, Integer> frequent = frequencies(result);

        int sum = sum(result);
        double average = average(result);
        int min = min(result);
        int max = max(result);
        int passed = countPassed(result);
        int notPassed = getNotPassed(result, passed);

        showResults(result);

        rateAverage(average);

        String texts = """
                Suma wyników wynosi: %s
                Średnia wyników wynosi: %s
                Podana minimalna wartość: %s
                Podana maksymalna wartość: %s
                Ilość użytkowników, którzy przeszli dalej: %s
                Ilość użytkowników, którzy nie przeszli dalej: %s
                Unikalność: %s
                Ilość unikalności: %s
                Częstotliwość: %s
                """.formatted(sum, average, min, max, passed, notPassed, unique, unique.size(), frequent);
        System.out.print(texts);
        mostFrequent(frequent);
    }
}
