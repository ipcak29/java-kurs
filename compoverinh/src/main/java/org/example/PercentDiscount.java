package org.example;

import java.math.BigDecimal;

public class PercentDiscount implements Discount{
    @Override
    public BigDecimal getDiscount(BigDecimal productsValue) {
        BigDecimal tenPercent = productsValue.multiply(new BigDecimal("0.10"));
        return tenPercent.min(new BigDecimal("50"));
    }
}
