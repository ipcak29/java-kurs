package org.example;

import java.math.BigDecimal;

public interface Discount {
    BigDecimal getDiscount(BigDecimal productsValue);
}
