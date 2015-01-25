package com.gemtastic.lillakammaren.model;

/**
 *
 * @author Gemtastic
 */
public class Order {
    private final Customer customer;
    private final long orderno;
    private final Cart cart;
    
    public Order(Customer customer, long orderno, Cart cart){
        this.customer = customer;
        this.orderno = orderno;
        this.cart = cart;
    }
}
