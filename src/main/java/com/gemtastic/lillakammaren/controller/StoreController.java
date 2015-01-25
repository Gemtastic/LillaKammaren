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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gemtastic
 */
@Controller
public class StoreController {
    

    private ProductRepository repository;
    
    private final Cart cart = Cart.getInstance();
    
    @RequestMapping(value="store/{category}", method = RequestMethod.GET)
    public ModelAndView category(@PathVariable("category")String category) throws IOException{
        ModelAndView model = new ModelAndView();
        this.repository = ProductRepository.getInstance();
        model.setViewName("store");
        
        switch (category) {
            case "Nyheter":
                model.addObject("products", repository.getSpecialProduct("Nyheter"));
                break;
            case "REA":
                model.addObject("products", repository.getSpecialProduct("REA"));
                break;
            case "Spotlight":
                model.addObject("products", repository.getSpecialProduct("Spotlight"));
                break;
            default:
                model.addObject("products", repository.getAllProductsByCategory(category));
                break;
        }
        
        model.addObject("categories", repository.getAllCategories());
        model.addObject("cartsize", cart.getCartSize());
        return model;
    }
    
}
