package org.example;

import java.math.BigDecimal;

public class PickUpDelivery implements Delivery{
    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("0");
    }
}
