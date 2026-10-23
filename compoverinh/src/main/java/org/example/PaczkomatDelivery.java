package org.example;

import java.math.BigDecimal;

public class PaczkomatDelivery implements Delivery{
    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("10");
    }
}
