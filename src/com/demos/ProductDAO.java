package com.demos;

import java.util.*;

public class ProductDAO {
	private static ProductDAO instance;
    private static List<Product> data = new ArrayList<>();
     
    static {
        data.add(new Product(1, "iPhone X", 999.99f));
        data.add(new Product(2, "XBOX 360", 329.50f));     
    }
     
    private ProductDAO() {
         
    }
     
    public static ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDAO();
        }
         
        return instance;               
    }
     
    public List<Product> listAll() {
    
        return data;
    }
     
    public int add(Product product) {
        int newId = data.size() + 1;
        product.setId(newId);
        data.add(product);
         
        return newId;
    }
   
}
