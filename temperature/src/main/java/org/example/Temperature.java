package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> temperatures = new ArrayList<>();

        double avg;
        double sum = 0;
        double maxTemperature = Double.NEGATIVE_INFINITY;

        while (true) {
            System.out.println("Podaj temperature w °C:");
            if (!scanner.hasNextDouble()) {
                System.out.println("Błędne dane, ponów próbe ");
                scanner.nextLine();
                continue;
            }

            Double input = scanner.nextDouble();
            scanner.nextLine();
            temperatures.add(input);

            sum += input;
            avg = sum / temperatures.size();
            if (input > maxTemperature) {
                maxTemperature = input;
            }

            char choice;
            do {
                System.out.println("Czy chcesz podać kolejną temperature? y/n");
                choice = scanner.nextLine().charAt(0);

                if (choice != 'y' && choice != 'n') {
                    System.out.println("Błedne dane");
                }

            } while (choice != 'y' && choice != 'n');

            System.out.println("Koniec programu");
            break;
        }

        System.out.println("Średnia temperatura" + avg);
        System.out.println("Najwyższa temperatura" + maxTemperature);

        String aboveOrBelow = avg > 0
                ? "Średnia temperatura jest powyżej zera"
                : "Średnia temperatura jest równa zeru lub poniżej zera";
        System.out.println(aboveOrBelow);
    }
}