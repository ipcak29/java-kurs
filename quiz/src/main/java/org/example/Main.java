package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        QuizInterface quizInterface = new QuizInterface();
        Scanner scanner = new Scanner(System.in);

        quizInterface.start(scanner);
    }
}
