package com.gemtastic.lillakammaren.model;

/**
 *
 * @author Gemtastic
 */
public class Product {
    private String name;
    private String description;
    private String img;
    private int price;
    private int id;
    
    public Product(String name, String description, String img, int price, int id){
        this.name = name;
        this.description = description;
        this.img = img;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }

    public int getPrice() {
        return price;
    }
    
    public int getId() {
        return price;
    }
}
