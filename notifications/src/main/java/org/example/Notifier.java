package org.example;

public interface Notifier {
    String getRecipientKey();
    String getDescription();
    void send(String message);
}
