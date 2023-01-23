package com.amazon.productservice.controller;

import com.amazon.productservice.dto.ProductRequest;
import com.amazon.productservice.dto.ProductResponse;
import com.amazon.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value={"/api"})
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/createproduct")
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.saveProduct(productRequest);
        System.out.println("Product saved !!!!!!!!!!!");
    }

    @GetMapping("/product")
    public ProductResponse product(@RequestParam String name){
       return  productService.reciveProduct(name);
    }
}
