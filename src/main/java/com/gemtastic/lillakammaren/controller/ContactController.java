package com.gemtastic.lillakammaren.controller;

import com.gemtastic.lillakammaren.model.Cart;
import com.gemtastic.lillakammaren.model.Message;
import com.gemtastic.lillakammaren.repository.MessageRepository;
import com.gemtastic.lillakammaren.repository.ProductRepository;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * The contact controller only has three jobs; to display the site, to receive
 * the messages and to add the messages to the MessageRepository.
 * 
 * @author Gemtastic
 */
@Controller
public class ContactController {
    
    private final Cart cart = Cart.getInstance();

    private ProductRepository repository;
    private final MessageRepository messages = MessageRepository.getInstance();
    
    /**
     * Displays the view of the contact us site.
     * 
     * @return
     * @throws IOException 
     */
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView contact() throws IOException{
        this.repository = ProductRepository.getInstance();
        ModelAndView model = new ModelAndView();
        model.setViewName("contact_us");
        model.addObject("categories", repository.getAllCategories());
        model.addObject("cartsize", cart.getCartSize());
        return model;
    }
    
    /**
     * Receives and stores messages.
     * 
     * @param message
     * @return 
     */
    @ResponseBody
    @RequestMapping(value="/contact/sendmessage", method = RequestMethod.POST)
    public String recieveMessage(@ModelAttribute Message message){
        messages.addMessage(message);
        return "Message received!";
    }
}
