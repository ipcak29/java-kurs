package org.example;

public class Letter extends Shipment {
    private final boolean registered;

    public Letter(String id, String recipient, boolean registered) {
        super(id, recipient);
        this.registered = registered;
    }

    @Override
    public int calculateCost() {
        if (registered) {
            return 1000;
        } else {
            return 600;
        }
    }

    @Override
    public String getDescription() {
        if (registered){
            return "List polecony";
        }else{
            return "List zwykły";
        }
    }
}