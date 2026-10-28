package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShipmentManager {
  private final Map<String, Shipment>shipments = new HashMap<>();

  public boolean addShipment(Shipment shipment){
    String normalize = shipment.getId().trim().toUpperCase();
    if (shipments.containsKey(normalize)){
      return false;
    }
    shipments.put(normalize, shipment);
    return true;
  }

  public Shipment findById(String id){
    String normalizedId = id.trim().toUpperCase();
    return shipments.get(normalizedId);
  }

  public int calculateUnsentCost(){
    int total = 0;
    for (Shipment shipment : shipments.values()){
      if (!shipment.isSent()){
      total += shipment.calculateCost();
      }
    }
    return total;
  }

  public List<Shipment> getAllShipments(){
    return new ArrayList<>(shipments.values());
    }
  }