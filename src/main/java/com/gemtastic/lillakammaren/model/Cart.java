package com.gemtastic.lillakammaren.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Gemtastic
 */
public class Cart {
    
    private static Cart instance;
    private int size = 0;
    
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
    }
    
    public void removeProduct(Product p, int amount){
        if(cart.containsKey(p)){
            cart.remove(p, amount);
        }
    }
    
    public void emptyCart(){
        cart.clear();
    }
    
    @ModelAttribute("cartcontent")
    public Map<Product, Integer> getCartContent(){
        return cart;
    }
    
    @ModelAttribute("cartsize")
    public int getCartSize(){
//        if(cart.isEmpty()){
//            size = 0;
//        }else{
//            for(Map.Entry<Product, Integer> entry : cart.entrySet()){
//                size = size + entry.getValue();
//            }
//        }
        return size;
    }
}
