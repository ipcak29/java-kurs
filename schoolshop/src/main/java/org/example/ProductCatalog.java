package org.example;

import java.util.*;

public class ProductCatalog {
    Map<String, Product> catalog = new HashMap<>();

    public ProductCatalog() {
        catalog.put("Z1", new Product("Z1", "zeszyt", 500, 5));
        catalog.put("D1", new Product("D1", "dlugopis", 300, 10));
        catalog.put("P1", new Product("P1", "plecak", 10000, 2));
    }

    public Product findProduct(String code) {
        String normalize = code.trim().toUpperCase();
        return catalog.get(normalize);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(catalog.values());
    }
}