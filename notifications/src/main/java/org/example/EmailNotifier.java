package org.example;

public class EmailNotifier implements Notifier{
    private final String address;
    private static int createdCount;

    public EmailNotifier(String address) {
        this.address = address;
        createdCount++;
    }

    @Override
    public String getRecipientKey() {
        return "email " + address.trim().toLowerCase();
    }

    @Override
    public String getDescription() {
        return "E-mail: " + address;
    }

    @Override
    public void send(String message) {
        System.out.printf("Kanał: %s%nAdres Odbiorcy: %s%nTreść wiadomości: %s%n",
               "E-mail", address, message);
    }
    public static int getCreatedCount(){
        return createdCount;
    }
}
