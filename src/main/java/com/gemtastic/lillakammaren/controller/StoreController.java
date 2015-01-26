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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This is the store controller; it generates an individual view depending on
 * the string it receives. It will then display products of only that category.
 * 
 * It is completely agnostic to what categories in the repository.
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
