package com.gemtastic.lillakammaren.controller;

import com.gemtastic.lillakammaren.model.Cart;
import com.gemtastic.lillakammaren.model.Product;
import com.gemtastic.lillakammaren.repository.ProductRepository;
import java.io.IOException;
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
public class CartController {
    

    private ProductRepository repository;

    private final Cart cart = Cart.getInstance();
    
    @RequestMapping(value="/cart", method = RequestMethod.GET)
    public ModelAndView cart() throws IOException{
        this.repository = ProductRepository.getInstance();
        ModelAndView model = new ModelAndView();
        model.setViewName("cart");
        model.addObject("categories", repository.getAllCategories());
        model.addObject("cartcontent", cart.getCartContent());
        model.addObject("cartsize", cart.getCartSize());
        model.addObject("carttotal", cart.getCartTotal());
        return model;
    }
    
    @RequestMapping(value="/cart", method = RequestMethod.POST)
    public ModelAndView addToCart(@RequestParam("productId") String productId) throws IOException{
        ModelAndView model = new ModelAndView();
        this.repository = ProductRepository.getInstance();
        if (productId == null) {
            System.out.println("Input is null");
        }else{
            try {
                int id = Integer.parseInt(productId);
                Product product = repository.getProductByID(id);
                cart.addItem(product);
            } catch (NumberFormatException e) {
                System.out.println("Oops! Something went wrong:" + e);
            }
        }
        return model;
    }
}
