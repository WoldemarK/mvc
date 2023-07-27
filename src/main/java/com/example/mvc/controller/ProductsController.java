package com.example.mvc.controller;

import com.example.mvc.model.Product;
import com.example.mvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;
    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public String addProduct(@RequestParam(required = false) String name,
                             @RequestParam(required = false) double price,
                             Model model) {
        var product = Product.builder()
                .name(name)
                .price(price)
                .build();

        productService.addProduct(product);
        var productList = productService.findAll();
        model.addAttribute("products", productList);

        return "products.html";
    }
    @GetMapping("/products")
    public String viewProducts(Model model) {
        var productList = productService.findAll();
        model.addAttribute("products", productList);
        return "products.html";
    }
}
