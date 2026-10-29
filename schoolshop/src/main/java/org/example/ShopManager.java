package org.example;

import java.util.List;
import java.util.Map;

public class ShopManager {
    private final ProductCatalog productCatalog = new ProductCatalog();
    private final ShoppingCart shoppingCart = new ShoppingCart();

    public List<Product> getAllProducts() {
        return productCatalog.getAllProducts();
    }

    public Map<String, Integer> getCartItems() {
        return shoppingCart.getItems();
    }

    public boolean addToCart(String code, int quantity) {
        Product product = productCatalog.findProduct(code);

        if (product == null) {
            return false;
        }

        return shoppingCart.addProduct(product, quantity);
    }

    public boolean removeFromCart(String code, int quantity) {
        Product product = productCatalog.findProduct(code);

        if (product == null) {
            return false;
        }

        return shoppingCart.removeProduct(code, quantity);
    }

    public int getTotalPriceInGrosze() {
        Map<String, Integer> cart = shoppingCart.getItems();
        int total = 0;
        for (String code : cart.keySet()) {
            Product product = productCatalog.findProduct(code);
            int quantity = cart.get(code);
            total += product.getPriceInGrosze() * quantity;
        }
        return total;
    }

    public Product findProduct(String code) {
        return productCatalog.findProduct(code);
    }

    public void clearCart() {
        shoppingCart.clearCart();
    }

    public boolean purchase(){
        Map<String, Integer>cartItems =shoppingCart.getItems();
        if (cartItems.isEmpty()){
            return false;
        }
        for (String code : cartItems.keySet()){
            Product product = productCatalog.findProduct(code);
            int quantity = cartItems.get(code);

            if(product.getStock() < quantity){
                return false;
            }
        }

        for (String code : cartItems.keySet()){
            Product product = productCatalog.findProduct(code);
            int quantity = cartItems.get(code);
            product.lowerStock(quantity);
        }
        clearCart();
        return true;
    }
}