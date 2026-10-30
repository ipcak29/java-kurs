package org.example;

public class SmsNotifier implements Notifier{
    private final String phoneNumber;
    private static int createdCount;

    public SmsNotifier(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        createdCount++;
    }

    @Override
    public String getRecipientKey() {
        return "SMS: " + phoneNumber.replace(" ", "");
    }

    @Override
    public String getDescription() {
        return "SMS: " + phoneNumber;
    }

    @Override
    public void send(String message) {
        System.out.printf("Kanał: %s%nNumer odbiorcy: %s%nTreść wiadomości: %s%n",
                "SMS", phoneNumber, message);
    }

    public static int getCreatedCount(){
        return createdCount;
    }
}
