package org.example;

public class Product {
    private final String code;
    private final String name;
    private final int priceInGrosze;
    private int stock;

    public Product(String code, String name, int priceInGrosze, int stock) {
        this.code = code;
        this.name = name;
        this.priceInGrosze = priceInGrosze;
        this.stock = stock;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPriceInGrosze() {
        return priceInGrosze;
    }

    public int getStock() {
        return stock;
    }

    public void lowerStock(int quantity) {
        if (quantity <= stock && quantity > 0) {
            stock -= quantity;
        }
    }
}