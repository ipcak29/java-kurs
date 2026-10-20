package org.example;

import java.math.BigDecimal;

public class CourierDelivery implements Delivery{
    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("15");
    }
}
