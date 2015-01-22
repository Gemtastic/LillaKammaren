/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.lillakammaren.controller;

import com.gemtastic.lillakammaren.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gemtastic
 */
@Controller
public class StoreController {
    
    @Autowired
    private ProductRepository repository;
    
    @RequestMapping(value="store/{category}", method = RequestMethod.GET)
    public ModelAndView products(){
        ModelAndView model = new ModelAndView();
        model.setViewName("store");
        model.addObject("categories", repository.getAllCategories());
        return model;
    }
    
}
