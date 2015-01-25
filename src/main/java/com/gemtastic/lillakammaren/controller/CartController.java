package com.gemtastic.lillakammaren.controller;

import com.gemtastic.lillakammaren.model.Cart;
import com.gemtastic.lillakammaren.model.Customer;
import com.gemtastic.lillakammaren.model.Product;
import com.gemtastic.lillakammaren.repository.ProductRepository;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    
    @ResponseBody
    @RequestMapping(value="/cart", method = RequestMethod.POST)
    public String addItemToCart(@RequestParam("productId") String productId) throws IOException{
        this.repository = ProductRepository.getInstance();
        try {
            int id = Integer.parseInt(productId);
            Product product = repository.getProductByID(id);
            cart.addItem(product);
        } catch (NumberFormatException e) {
            System.out.println("Oops! Something went wrong:" + e);
        }
        return String.valueOf(cart.getCartSize());
    }
    
    @ResponseBody
    @RequestMapping(value = "/cart/sendorder", method = RequestMethod.POST)
    public String submitOrder(@ModelAttribute Customer customer){
        System.out.println(customer.getName());
        return "Order received!";
    }
    
    @ResponseBody
    @RequestMapping(value = "/cart/remove", method = RequestMethod.POST)
    public String removeItemFromCart(@RequestParam("itemId") String itemId) throws IOException{
        int id = Integer.parseInt(itemId);
        Product product = repository.getProductByID(id);
        int newItemSize = 0;
        if (cart.getCartSize() != 0 && cart.containsProduct(product)) {
            cart.removeProduct(product, 1);
            newItemSize = cart.getAmount(product);
        }
        
        String returnmsg = String.valueOf(newItemSize);
        return returnmsg;
    }
}
