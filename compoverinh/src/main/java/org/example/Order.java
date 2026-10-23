package org.example;

import java.math.BigDecimal;

public class Order {
    private final String client;
    private Delivery delivery;
    private Discount discount;
    private final BigDecimal productsValue;

    public Order(String client, Delivery delivery, Discount discount, BigDecimal productsValue) {
        this.client = client;
        this.delivery = delivery;
        this.discount = discount;
        this.productsValue = productsValue;
    }

    public BigDecimal calculateTotal() {
        BigDecimal discountAmount = discount.getDiscount(productsValue);
        BigDecimal deliveryPrice = delivery.getPrice();
        return productsValue.subtract(discountAmount).add(deliveryPrice);
    }

    public void setDelivery(Delivery newDelivery) {
        this.delivery = newDelivery;
    }

    public void setDiscount(Discount newDiscount) {
        this.discount = newDiscount;
    }
}