package com.gemtastic.lillakammaren.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemtastic.lillakammaren.model.Product;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;


/**
 *
 * @author Gemtastic
 */
@Repository
public class ProductRepository {
    
//    public static ProductRepository instance;
//    
//    public static ProductRepository getInstance() throws IOException{
//        if(instance == null){
//            synchronized(ProductRepository.class){
//                if(instance == null){
//                    instance = new ProductRepository();
//                }
//            }
//        }
//        
//        return instance;
//    }
    
    private List<Product> products;
    private final List<String> categories;
    
    private ProductRepository() throws IOException{
        this.products = new ArrayList<>();
        this.categories = new ArrayList<>();
        
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Product>> typeRef = new TypeReference<List<Product>>(){};
        InputStream in = ProductRepository.class.getResourceAsStream("/JSON/database.json");
        if (in == null) {
            throw new IOException("Resource not found");
        }
        try(Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8)){
            products = mapper.readValue(reader, typeRef);
        }
        for(Product p : products){
            
            if(!categories.contains(p.getCategory())){
                categories.add(p.getCategory());
            }
        }
    }
    
    
    public List<Product> getAllProducts(){
        return products;
    }
    
    public Product getProductByID(int id) {
        for(Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }
        throw new IllegalArgumentException("Specified Product ID does not exist.");
    }
    
    @ModelAttribute("categories")
    public List<String> getAllCategories(){
        return categories;
    }
    
}
