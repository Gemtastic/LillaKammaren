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
 * The Product repository is reading a JSON file to retrieve this store's
 * current wares. It is completely agnostic to what wares there are, what 
 * categories they are and how many. As long as each ware follows the bean
 * this class will be happy.
 * 
 * Its utility methods are retrieving the current repository, specifically 
 * all the products, all the categories or the special wares of a specific 
 * kind.
 * 
 * @author Gemtastic
 */
@Repository
public class ProductRepository {

    public static ProductRepository instance;

    public static ProductRepository getInstance() throws IOException {
        if (instance == null) {
            synchronized (ProductRepository.class) {
                if (instance == null) {
                    instance = new ProductRepository();
                }
            }
        }

        return instance;
    }

    private List<Product> products;
    private final List<String> categories;

    /**
     * The product repository loads the JSON and reads it upon creation.
     * 
     * @throws IOException 
     */
    private ProductRepository() throws IOException {
        this.products = new ArrayList<>();
        this.categories = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Product>> typeRef = new TypeReference<List<Product>>() {
        };
        InputStream in = ProductRepository.class.getResourceAsStream("/JSON/database.json");
        if (in == null) {
            throw new IOException("Resource not found");
        }
        try (Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
            products = mapper.readValue(reader, typeRef);
        }
        for (Product p : products) {

            if (!categories.contains(p.getCategory())) {
                categories.add(p.getCategory());
            }
        }
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductByID(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new IllegalArgumentException("Specified Product ID does not exist.");
    }

    public List<String> getAllCategories() {
        return categories;
    }

    /**
     * This method sorts out the items of the specified category and returns 
     * them as a list.
     * 
     * @param category
     * @return 
     */
    public List<Product> getAllProductsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList();
        for (Product p : products) {
            if (p.getCategory().equals(category)) {
                productsByCategory.add(p);
            }
        }
        return productsByCategory;
    }

    /**
     * This method checks against a string if it is a special product and then 
     * sorts out the specified special product from the repository and returns
     * them.
     * 
     * @param special
     * @return 
     */
    public List<Product> getSpecialProduct(String special) {
        List<Product> specialProducts = new ArrayList<>();
        switch (special) {
            case "Nyheter":
                for (Product p : products) {
                    if (p.isNewItem()) {
                        specialProducts.add(p);
                    }
                }
                break;
            case "REA":
                for (Product p : products) {
                    if (p.isSale()) {
                        specialProducts.add(p);
                    }
                }
                break;
            case "Spotlight":
                for (Product p : products) {
                    if (p.isSpotlight()) {
                        specialProducts.add(p);
                    }
                }
                break;
            default:
                System.out.println("This was not a special product.");
                break;
        }
        return specialProducts;
    }

}
