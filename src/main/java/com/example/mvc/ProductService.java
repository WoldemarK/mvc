package com.example.mvc;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    private final List<Product>products = new ArrayList<>();

    {
        products.add(new Product("Test1", 1.0));
        products.add(new Product("Test2", 2.0));
        products.add(new Product("Test3", 3.0));
        products.add(new Product("Test4", 4.0));
    }
    public void addProduct(Product product){
        this.products.add(product);
    }
    public List<Product>findAll(){
        return this.products;
    }
}
