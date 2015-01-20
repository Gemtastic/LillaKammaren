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


/**
 *
 * @author Gemtastic
 */
public class ProductRepository {
    
    public static ProductRepository instance;
    
    public static ProductRepository getInstance() throws IOException{
        if(instance == null){
            synchronized(ProductRepository.class){
                if(instance == null){
                    instance = new ProductRepository();
                }
            }
        }
        
        return instance;
    }
    
    private List<Product> products;
    
    private ProductRepository() throws IOException{
        this.products = new ArrayList();
        
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Product>> typeRef = new TypeReference<List<Product>>(){};
        InputStream in = ProductRepository.class.getResourceAsStream("/database.json");
        if (in == null) {
            throw new IOException("Resource not found");
        }
        try(Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8)){
            products = mapper.readValue(reader, typeRef);
        }
        for(Product p : products){
            products.add(p);
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
    
}
