package org.example;

import java.math.BigDecimal;

public class Ticket {
    private String eventName;
    private BigDecimal ticketPrice;
    private int availableSeats;

    public Ticket(String eventName, BigDecimal ticketPrice, int availableSeats) {
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
    }

    public String getEventName() {
        return eventName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public BigDecimal calculateCost(int numberOfTickets) {
        return ticketPrice.multiply(BigDecimal.valueOf(numberOfTickets));
    }

    public boolean buy(int numberOfTickets) {
        if (numberOfTickets > 0 && numberOfTickets <= availableSeats) {
            availableSeats -=numberOfTickets;
            return true;
        }
        return false;
    }
}
