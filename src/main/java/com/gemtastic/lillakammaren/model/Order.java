package com.gemtastic.lillakammaren.model;

/**
 * The order stores the three different object relevant to the orders made; the
 * customer bean, the generated order number and the cart.
 * 
 * @author Gemtastic
 */
public class Order {
    private final Customer customer;
    private final float orderno;
    private final Cart cart;
    
    public Order(Customer customer, float orderno, Cart cart){
        this.customer = customer;
        this.orderno = orderno;
        this.cart = cart;
    }
}
