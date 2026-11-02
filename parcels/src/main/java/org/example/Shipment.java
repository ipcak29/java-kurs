package org.example;

public abstract class Shipment {
    private final String id;
    private final String recipient;
    private boolean sent = false;

    public Shipment(String id, String recipient) {
        this.id = id.trim().toUpperCase();
        this.recipient = recipient;
    }

    public String getId() {
        return id;
    }

    public String getRecipient() {
        return recipient;
    }

    public boolean isSent() {
        return sent;
    }

     public abstract int calculateCost();

    public abstract String getDescription();

    public void markSent(){
        sent = true;
    }
}