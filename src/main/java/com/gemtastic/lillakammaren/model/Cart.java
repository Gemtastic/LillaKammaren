package com.gemtastic.lillakammaren.model;

import java.util.HashMap;
import java.util.Map;

/**
 * The cart holds a HashMap of the product and the amount of products added to 
 * cart, the total item size of the cart, and the total sum of them all.
 * 
 * It has 8 utility methods to help you manage adding, removing, receiving size, 
 * sum total, checking if the item exist in the cart, how many of an item 
 * exists in the cart, what items are in the cart and emptying the cart.
 * 
 * @author Gemtastic
 */
public class Cart {
    
    private final Map<Product, Integer> cart;
    
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

    
    private Cart(){
        cart = new HashMap<>();
    }
    
    /**
     * Adding one item to the cart.
     * 
     * @param p 
     */
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
    
    /**
     * Removing one product from the cart.
     * 
     * @param p 
     */
    public void removeProduct(Product p){
        if(cart.get(p) != 0){
            cart.put(p, cart.get(p) - 1);
            size = size - 1;
            total = total - p.getPrice();
        }
        if(cart.get(p) == 0){
            cart.remove(p);
        }
        System.out.println(cart);
    }
    
    /**
     * Completely empties the cart.
     */
    public void emptyCart(){
        cart.clear();
        size = 0;
        total = 0;
    }
    
    /**
     * Returns the HashMap of the cart content.
     * @return 
     */
    public Map<Product, Integer> getCartContent(){
        return cart;
    }
    
    /**
     * This retrieves the total item size of the cart, not the amount of 
     * different items in the cart.
     * 
     * @return 
     */
    public int getCartSize(){
        return size;
    }
    
    /**
     * Returns the total of the cart.
     * @return 
     */
    public int getCartTotal(){
        return total;
    }
    
    /**
     * Checks if the specified product exists in the cart.
     * 
     * @param product
     * @return 
     */
    public boolean containsProduct(Product product){
        return cart.containsKey(product);
    }
    
    /**
     * Gets the amount of a product there is in the cart.
     * @param product
     * @return 
     */
    public int getAmount(Product product){
        return cart.get(product);
    }
}
