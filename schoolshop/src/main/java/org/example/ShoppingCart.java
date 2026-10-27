package org.example;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
   private final Map<String, Integer> cart = new HashMap<>();

   public boolean addProduct(Product product, int quantity){
       int currentQuant = cart.getOrDefault(product.getCode(), 0);
       if (quantity <= 0 || currentQuant + quantity > product.getStock()){
           return false;
       }
           cart.put(product.getCode(), currentQuant + quantity);
           return true;
       }

       public boolean removeProduct(String code, int quantity){
            int currentQuant = cart.getOrDefault(code, 0);
            if (quantity <= 0 || quantity > currentQuant) {
                return false;
            }

            if (quantity == currentQuant){
                cart.remove(code);
            }else{
                cart.put(code, currentQuant - quantity);
            }
            return true;
       }

       public Map<String, Integer> getItems(){
       return new HashMap<>(cart);
       }

       public void clearCart(){
       cart.clear();
       }
   }