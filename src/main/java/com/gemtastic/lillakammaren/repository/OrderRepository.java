package com.gemtastic.lillakammaren.repository;

import com.gemtastic.lillakammaren.model.Order;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This order repository does not provide any way to view the orders on the site.
 * @author Gemtastic
 */
public class OrderRepository {
    public static OrderRepository instance;
    private Map<Long, Order> orders;
//    private Map<Customer, Cart> order = new HashMap<>();
    
    public static OrderRepository getInstance() throws IOException{
        if(instance == null){
            synchronized(OrderRepository.class){
                if(instance == null){
                    instance = new OrderRepository();
                }
            }
        }
        return instance;
    }
    
    private OrderRepository(){
        orders = new HashMap<>();
    }
    
    public void addOrder(Order order, long orderno){
        orders.put(orderno, order);
    }
    
    public Order getOrder(long orderno){
        Order order = orders.get(orderno);
        return order;
    }
    
}
