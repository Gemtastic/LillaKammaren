package com.gemtastic.lillakammaren.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gemtastic
 */
public class Order {
    private String name;
    private String surname;
    private String address;
    private String coaddress;
    private String zip;
    private String city;
    private String phone;
    private String email;
    private int orderno;
    
    private final Map<ArrayList, Integer> order = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoaddress() {
        return coaddress;
    }

    public void setCoaddress(String coaddress) {
        this.coaddress = coaddress;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOrderno() {
        return orderno;
    }

    public void setOrderno(int orderno) {
        this.orderno = orderno;
    }
    
    public void setOrder(ArrayList<Product> products, int total){
        order.put(products, total);
    }
    
    public Map<ArrayList, Integer> getOrder(){
        return order;
    }
}
