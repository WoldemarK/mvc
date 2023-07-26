package com.example.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping("/products1")
    public String viewProducts1(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }
    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public String addProduct(@RequestParam String name,
                             @RequestParam double price,
                             Model model) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productService.addProduct(product);
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }
    @GetMapping("/products")
    public String viewProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }
}
