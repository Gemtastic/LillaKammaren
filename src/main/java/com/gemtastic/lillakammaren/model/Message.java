package com.gemtastic.lillakammaren.model;

/**
 * The message is a simple bean with only getters and setter for the 
 * message info.
 * 
 * @author Gemtastic
 */
public class Message {
    private String name;
    private String email;
    private String orderno;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
