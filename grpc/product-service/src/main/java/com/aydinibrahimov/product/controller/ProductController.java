package com.aydinibrahimov.product.controller;


import com.aydinibrahimov.product.model.Category;
import com.aydinibrahimov.product.model.Product;
import com.aydinibrahimov.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product/")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        var result = productService.addProduct(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
     return    ResponseEntity.status(HttpStatus.OK)
                .body(productService.getAllProducts());
    }
}
