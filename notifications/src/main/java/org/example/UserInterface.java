package org.example;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    private final NotificationManager notificationManager = new NotificationManager();

    public void showChannels() {
        Map<String, Notifier> channels = notificationManager.getChannels();
        for (String alias : channels.keySet()) {
            Notifier notifier = channels.get(alias);
            System.out.println(alias + " " + notifier.getDescription());
        }
    }

    public void handleSendByAlias(Scanner scanner) {
        scanner.nextLine();

        System.out.println("Podaj alias kanału: ");
        String alias = scanner.nextLine();

        System.out.println("Podaj treść wiadomości: ");
        String message = scanner.nextLine();

        boolean sent = notificationManager.sendByAlias(alias, message);

        if (sent) {
            System.out.println("Wiadomość wysłana");
        } else {
            System.out.println("Nie wysłano wiadomości");
        }
    }

    public void showHistory() {
        List<String> historian = notificationManager.getHistory();

        for (String entry : historian) {
            System.out.println(entry);
        }
    }

    public void showChannelCount() {
        System.out.printf("Aktualna liczba kanałów: %d%nUtworzone e-maile: %d%nUtworzone sms-y: %d%n",
                notificationManager.getChannelCount(), EmailNotifier.getCreatedCount(), SmsNotifier.getCreatedCount());
    }

    public void handleSendToAll(Scanner scanner) {
        scanner.nextLine();

        System.out.println("Podaj zawartość wiadomości: ");
        String message = scanner.nextLine();

        if (message.trim().isEmpty()) {
            System.out.println("Zawartość nie może być pusta");
            return;
        }

        notificationManager.sendToAll(message);
    }

    public void handleAddMail(Scanner scanner){
        scanner.nextLine();

        System.out.println("Podaj alias kanału: ");
        String alias = scanner.nextLine();

        System.out.println("Podaj mail: ");
        String mail = scanner.nextLine();

        if (mail.trim().isEmpty()){
            System.out.println("Mail nie moze być pusty");
            return;
        }

        boolean giveMail = notificationManager.addEmail(alias, mail);

        if (giveMail){
            System.out.println("Pomyślnie dodano mail");
        }else{
            System.out.println("Nie udało sie dodac maila");
        }
    }

    public void handleRemoveChannel(Scanner scanner){
        scanner.nextLine();

        System.out.println("Podaj alias do usunięcia: ");
        String alias = scanner.nextLine();

        if (alias.trim().isEmpty()){
            System.out.println("Alias nie może być pusty");
            return;
        }

        boolean deleteChannel = notificationManager.removeChannel(alias);

        if (deleteChannel){
            System.out.println("Pomyślnie usunięto kanał");
        }else{
            System.out.println("Nie udało sie usunąc kanału");
        }
    }

    public void handleAddSms(Scanner scanner){
    scanner.nextLine();

        System.out.println("Podaj alias kanału: ");
        String alias = scanner.nextLine();

        System.out.println("Podaj numer telefonu: ");
        String number = scanner.nextLine();

        if (number.trim().isEmpty()){
            System.out.println("Numeru nie udalo sie dodac");
            return;
        }

        boolean giveNumber = notificationManager.addSms(alias, number);

        if (giveNumber){
            System.out.println("Pomyślnie dodano numer");
        }else{
            System.out.println("Nie udało sie dodac");
        }
    }

    public void showMenu(){
        String textMenu= """
                1.Dodaj e-mail
                2.Dodaj SMS
                3.Pokaż kanały
                4.Usuń kanał
                5.Wyślij do jednego
                6.Wyślij do wszystkich
                7.Historia
                8.Liczniki
                0.Wyjście
                """;
        System.out.println(textMenu);
    }

    public void startMenu(Scanner scanner){
        int choice = -1;

        while (choice != 0){
        showMenu();

        choice = scanner.nextInt();
            switch (choice){
                case 1 -> handleAddMail(scanner);
                case 2 -> handleAddSms(scanner);
                case 3 -> showChannels();
                case 4 -> handleRemoveChannel(scanner);
                case 5 -> handleSendByAlias(scanner);
                case 6 -> handleSendToAll(scanner);
                case 7 -> showHistory();
                case 8 -> showChannelCount();
                case 0 -> System.out.println("Do widzenia");
            }
        }
    }
}