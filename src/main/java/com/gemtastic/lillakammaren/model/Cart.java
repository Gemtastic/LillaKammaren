package com.gemtastic.lillakammaren.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gemtastic
 */
public class Cart {
    
    private static Cart instance;
    private int size = 0;
    private int total = 0;
    
    public static Cart getInstance() {
        if (instance == null) {
            synchronized(Cart.class) {
                if (instance == null) {
                    instance = new Cart();
                }
            }
        }
        
        return instance;
    }
    
    private final Map<Product, Integer> cart;
    
    public Cart(){
        cart = new HashMap<>();
    }
    
    public void addItem(Product p){
        if(cart.containsKey(p)){
            Integer amount = cart.get(p);
            cart.put(p, amount + 1);
        }else{
            cart.put(p, 1);
        }
        size = size + 1;
        total =  total + p.getPrice();
    }
    
    public void removeProduct(Product p, int amount){
        if(cart.containsKey(p)){
            cart.remove(p, amount);
        }
    }
    
    public void emptyCart(){
        cart.clear();
        size = 0;
    }
    

    public Map<Product, Integer> getCartContent(){
        return cart;
    }
    

    public int getCartSize(){
        return size;
    }
    
    public int getCartTotal(){
        return total;
    }
}
