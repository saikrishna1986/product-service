package com.amazon.productservice.service;

import com.amazon.productservice.dto.ProductRequest;
import com.amazon.productservice.dto.ProductResponse;
import com.amazon.productservice.model.Product;
import com.amazon.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(ProductRequest request) {

        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

        Product productsaved = productRepository.save(product);

        log.info("Product {} saved in database ", productsaved.getId());
    }


    public ProductResponse reciveProduct(String name) {
        Product products = productRepository.findByName(name);
        log.info("Product {} selected from database ", products.getId());
        ProductResponse response = ProductResponse.builder()
                .id(products.getId())
                .name(products.getName())
                .price(products.getPrice())
                .description(products.getDescription())
                .build();
        return response;
    }
}
