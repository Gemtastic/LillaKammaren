package com.gemtastic.lillakammaren.controller;

import com.gemtastic.lillakammaren.model.Cart;
import com.gemtastic.lillakammaren.model.Customer;
import com.gemtastic.lillakammaren.model.Order;
import com.gemtastic.lillakammaren.model.Product;
import com.gemtastic.lillakammaren.repository.OrderRepository;
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
 * The cart controller.
 * 
 * This controller handles everything connected to the cart. It contains one get 
 * and four post methods.
 * 
 * It handles displaying the cart (GET), adding to the cart(POST), removing one
 * item from the cart (POST), emptying the entire cart (POST) and also receiving
 * the orders (POST).
 * 
 * @author Gemtastic
 */
@Controller
public class CartController {
    

    private ProductRepository repository;
    private OrderRepository orderRepository;
            
    private final Cart cart = Cart.getInstance();
    
    /**
     * Retrieves the view of the cart and set the attributes to be used in them.
     * 
     * @return
     * @throws IOException 
     */
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
    
    /**
     * Adds one product to the cart.
     * 
     * @param productId
     * @return
     * @throws IOException 
     */
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
    
    /**
     * This method accepts the customer information for the order and combines 
     * that with the current cart along with a generated order number and puts
     * them as one entry into the order repository.
     * 
     * @param customer
     * @return
     * @throws IOException 
     */
    @ResponseBody
    @RequestMapping(value = "/cart/sendorder", method = RequestMethod.POST)
    public String submitOrder(@ModelAttribute Customer customer) throws IOException{
        orderRepository = OrderRepository.getInstance();
        float orderno = orderRepository.ordernoGenerator();
        Cart orderCart = cart;
        Order order = new Order(customer, orderno, orderCart);
        orderRepository.addOrder(order, orderno);
        return "Order received!";
    }
    
    /**
     * This method removes one item from the cart. It double-checks that the
     * number of items left never returns a null.
     * 
     * @param itemId
     * @return
     * @throws IOException 
     */
    @ResponseBody
    @RequestMapping(value = "/cart/remove", method = RequestMethod.POST)
    public String removeItemFromCart(@RequestParam("itemId") String itemId) throws IOException{
        int id = Integer.parseInt(itemId);
        Product product = repository.getProductByID(id);
        System.out.println(product);
        int newItemSize = 0;
        if (cart.getAmount(product) > 1 && cart.containsProduct(product)) {
            cart.removeProduct(product);
            newItemSize = cart.getAmount(product);
        }else if(cart.getAmount(product) == 1 && cart.containsProduct(product)){
            cart.removeProduct(product);
            newItemSize = 0;
        }
        
        String returnmsg = String.valueOf(newItemSize);
        return returnmsg;
    }
    
    /**
     * This methods empties the entire cart.
     * 
     * @param empty
     * @return 
     */
    @ResponseBody
    @RequestMapping(value = "/cart/empty", method = RequestMethod.POST)
    public String emptyTheCart(@RequestParam("empty") String empty){
        cart.emptyCart();
        
        return "Cart Emptied!";
    }
}
