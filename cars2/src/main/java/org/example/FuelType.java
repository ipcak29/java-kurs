package org.example;

import java.math.BigDecimal;

public enum FuelType {
    PETROL("8.30"),
    DIESEL("9.20"),
    ELECTRIC("3.20");

    private final BigDecimal price;

    FuelType(String price) {
        this.price = new BigDecimal(price);
    }

    public BigDecimal refuelPrice(double liters){
        return price.multiply(BigDecimal.valueOf(liters));
    }
    }

