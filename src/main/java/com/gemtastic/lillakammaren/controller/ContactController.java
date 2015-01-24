/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.lillakammaren.controller;

import com.gemtastic.lillakammaren.model.Cart;
import com.gemtastic.lillakammaren.repository.ProductRepository;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gemtastic
 */
@Controller
public class ContactController {
    
    private final Cart cart = Cart.getInstance();
    @Autowired
    private ProductRepository repository;
    
    @RequestMapping(value = "contact", method = RequestMethod.GET)
    public ModelAndView contact() throws IOException{
        this.repository = ProductRepository.getInstance();
        ModelAndView model = new ModelAndView();
        model.setViewName("contact_us");
        model.addObject("categories", repository.getAllCategories());
        model.addObject("cartsize", cart.getCartSize());
        return model;
    }
}
