package org.example;

import java.math.BigDecimal;

public class FixedDiscount implements Discount {
    @Override
    public BigDecimal getDiscount(BigDecimal productsValue) {
        return new BigDecimal("20");
    }
}
