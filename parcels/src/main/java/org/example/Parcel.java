package org.example;

public class Parcel extends Shipment {
private final int weightGrams;
    public Parcel(String id, String recipient, int weightGrams) {
        super(id, recipient);
        this.weightGrams = weightGrams;
    }

    @Override
    public int calculateCost() {
        if (weightGrams <= 1000){
            return 1200;
        } else if (weightGrams <= 5000) {
            return 1800;
        }else{
        return 2500;
        }
    }

    @Override
    public String getDescription() {
        return "Paczka, " + weightGrams + " g";
    }
}