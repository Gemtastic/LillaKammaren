/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.lillakammaren.controller;

import com.gemtastic.lillakammaren.model.Cart;
import com.gemtastic.lillakammaren.repository.ProductRepository;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The Index controller is managing the index site, or 'home' as it also is
 * referred to. It only displays the view and gives thymeleaf the objects to
 * render.
 * 
 * @author Gemtastic
 */
@Controller
public class IndexController {
    

    private ProductRepository repository;
    
    private final Cart cart = Cart.getInstance();
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws IOException {
        this.repository = ProductRepository.getInstance();
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("categories", repository.getAllCategories());
        model.addObject("cartsize", cart.getCartSize());
        return model;
    }
}
