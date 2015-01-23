package com.gemtastic.lillakammaren.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gemtastic
 */
public class Cart {
    
    private static Cart instance;
    private int size;
    
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
    }
    
    public void removeProduct(Product p, int amount){
        if(cart.containsKey(p)){
            cart.remove(p, amount);
        }
    }
    
    public void emptyCart(){
        cart.clear();
    }
    
    public List<CartContent> getCartContent(){
        ArrayList<CartContent> basket = new ArrayList<>();
        for(Product p : cart.keySet()){
            basket.add(new CartContent(p, cart.get(p)));
        }
        return basket;
    }
    
    public int getCartSize(){
        
        if(cart.isEmpty()){
            size = 0;
        }else{
            size = cart.size();
        }
        return size;
    }
}
