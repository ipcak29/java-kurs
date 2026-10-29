package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UserInterface {
    ShipmentManager shipmentManager = new ShipmentManager();

    public void showParcels() {
        List<Shipment> shipments = shipmentManager.getAllShipments();
        for (Shipment shipment : shipments) {
            System.out.printf("ID:  %s%n Odbiorca: %s%n %s Koszt: %d gr %n Nadana: %b%n",
                    shipment.getId(), shipment.getRecipient(), shipment.getDescription(),
                    shipment.calculateCost(), shipment.isSent());
        }
    }

    public void showUnsentCost() {
        int total = shipmentManager.calculateUnsentCost();
        System.out.printf("Koszt nienadanych przesyłek: %d gr%n", total);
    }

    public void showHistory() {
        List<String> history = shipmentManager.getSentHistory();
        for (String entry : history) {
            System.out.println(entry);
        }
    }

    public void showRecipients() {
        Set<String> unique = shipmentManager.uniqueRecipient();
        System.out.println(unique);
    }

    public void handleDeleteNotSent(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Podaj id przesyłki: ");
        String id = scanner.nextLine();
        boolean deleted = shipmentManager.deleteNotSent(id);
        if (deleted) {
            System.out.println("Usunięto przesyłkę ");
        } else {
            System.out.println("Nie udało się usunąć lub nie istnieje ");
        }
    }

    public void handleAddLetter(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Podaj id: ");
        String id = scanner.nextLine();
        System.out.println("Podaj odbiorcę: ");
        String recipient = scanner.nextLine();
        System.out.println("List ma być polecony czy zwykły? ");
        String type = scanner.nextLine();

        boolean registered = type.equals("polecony");
        Letter letter = new Letter(id, recipient, registered);
        boolean add = shipmentManager.addShipment(letter);

        if (add) {
            System.out.println("Pomyślnie dodano");
        } else {
            System.out.println("Nie udało się dodać, id jest zajęte");
        }
    }

    public void handleAddParcel(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Podaj id: ");
        String id = scanner.nextLine();
        System.out.println("Podaj odbiorcę: ");
        String recipient = scanner.nextLine();
        System.out.println("Podaj mase paczki: ");
        int weightGrams = scanner.nextInt();


        if (weightGrams <= 0) {
            System.out.println("Waga paczki musi być dodatnia");
            return;
        }

        Parcel parcel = new Parcel(id, recipient, weightGrams);
        boolean add = shipmentManager.addShipment(parcel);

        if (add) {
            System.out.println("Pomyślnie dodano");
        } else {
            System.out.println("Nie udało się dodac, zajęte ID");
        }
    }

    public void findShipmentById(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Podaj ID");
        String id = scanner.nextLine();
        Shipment shipment = shipmentManager.findById(id);

        if (shipment == null) {
            System.out.println("Nie odnaleziono przesyłki");
            return;
        }

        System.out.printf("ID: %s%nOdbiorca: %s%n%s%nKoszt: %d gr%nNadana: %b%n",
                shipment.getId(), shipment.getRecipient(), shipment.getDescription(), shipment.calculateCost(),
                shipment.isSent());
    }

    public void handleDispatch(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Podaj ID");
        String id = scanner.nextLine();
        boolean sent = shipmentManager.sendShipment(id);

        if (sent) {
            System.out.println("Pomyślnie nadano");
        } else {
            System.out.println("ID nie istnieje lub przesyłka była nadana");
        }
    }

    public void showMenu() {
        String textMenu = """
                1.Dodaj list
                2.Dodaj paczkę
                3.Rejestr
                4.Znajdź po ID
                5.Koszt nienadanych
                6.Nadaj
                7.Historia
                8.Odbiorcy
                9.Usuń
                0.Wyjście
                """;
        System.out.println(textMenu);
    }

    public void startMenu(Scanner scanner) {
        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> handleAddLetter(scanner);
                case 2 -> handleAddParcel(scanner);
                case 3 -> showParcels();
                case 4 -> findShipmentById(scanner);
                case 5 -> showUnsentCost();
                case 6 -> handleDispatch(scanner);
                case 7 -> showHistory();
                case 8 -> showRecipients();
                case 9 -> handleDeleteNotSent(scanner);
                case 0 -> System.out.println("Żegnam");
                default -> System.out.println("Błędna opcja");
            }
        }
    }
}