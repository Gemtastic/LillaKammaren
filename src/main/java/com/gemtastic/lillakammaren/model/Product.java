package com.gemtastic.lillakammaren.model;

/**
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
    
    public boolean getSale(){
        return sale;
    }
    
    public void setSale(boolean sale){
        this.sale = sale;
    }
}
