package org.example;

import java.math.BigDecimal;

public class NoDiscount implements Discount{
    @Override
    public BigDecimal getDiscount(BigDecimal productsValue) {
        return new BigDecimal("0");
    }
}
