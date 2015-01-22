/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.lillakammaren.controller;

import com.gemtastic.lillakammaren.repository.ProductRepository;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class IndexController {
    
    @Autowired
    private ProductRepository repository;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("categories", repository.getAllCategories());
        return model;
    }
}
