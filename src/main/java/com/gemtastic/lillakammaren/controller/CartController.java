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
public class CartController {
    
    private ProductRepository repository;
    
    private final Cart cart = Cart.getInstance();
    
    @RequestMapping(value="cart", method = RequestMethod.GET)
    public ModelAndView cart() throws IOException{

        
        this.repository = ProductRepository.getInstance();
        ModelAndView model = new ModelAndView();
        model.setViewName("cart");
        model.addObject("categories", repository.getAllCategories());
        model.addObject("cartContent", cart.getCartContent());
        return model;
    }
    
}
