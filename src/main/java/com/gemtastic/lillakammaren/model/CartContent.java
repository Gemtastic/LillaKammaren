package com.gemtastic.lillakammaren.model;

import com.gemtastic.lillakammaren.model.Product;

/**
 *
 * @author Gemtastic
 */
public class CartContent {
    private final Product product;
    private final int amount;
    
    public CartContent(Product product, int amount){
        this.product = product;
        this.amount = amount;
    }
}
