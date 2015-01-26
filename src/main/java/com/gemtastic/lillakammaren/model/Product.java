package com.gemtastic.lillakammaren.model;

/**
 * The product is the item in the store. It has all the information about the 
 * item, but it contains nothing more than getters and setters.
 * 
 * @author Gemtastic
 */
public class Product {
    private String name;
    private String description;
    private String img;
    private String category;
    private int price;
    private int id;
    private boolean sale;
    private boolean newItem;
    private boolean spotlight;

    public boolean isNewItem() {
        return newItem;
    }

    public void setNewItem(boolean newItem) {
        this.newItem = newItem;
    }

    public boolean isSpotlight() {
        return spotlight;
    }

    public void setSpotlight(boolean spotlight) {
        this.spotlight = spotlight;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public boolean isSale(){
        return sale;
    }
    
    public void setSale(boolean sale){
        this.sale = sale;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
