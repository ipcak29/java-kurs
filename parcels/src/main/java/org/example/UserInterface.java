package org.example;

import java.util.List;

public class UserInterface {
    ShipmentManager shipmentManager = new ShipmentManager();

    public void showParcels() {
        List<Shipment> shipments = shipmentManager.getAllShipments();
        for (Shipment shipment : shipments){
            System.out.printf("ID:  %s%n Odbiorca: %s%n %s Koszt: %d gr %n Nadana: %b%n",
                    shipment.getId(), shipment.getRecipient(), shipment.getDescription(),
                    shipment.calculateCost(), shipment.isSent());
        }
    }

    public void showUnsentCost(){
        int total = shipmentManager.calculateUnsentCost();
        System.out.printf("Koszt nienadanych przesyłek: %d gr%n", total);
    }
}
