package com.example.mvc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product>products=new ArrayList<>();

    {
        products.add(new Product("KJKJ", 9.0));
        products.add(new Product("KJKJ", 9.0));
        products.add(new Product("KJKJ", 9.0));
        products.add(new Product("KJKJ", 9.0));
    }

    public void addProduct(Product product){
        this.products.add(product);
    }
    public List<Product>findAll(){
        return this.products;
    }
}
