package com.aydinibrahimov.product.controller;


import com.aydinibrahimov.product.model.Category;
import com.aydinibrahimov.product.service.CategoryService;
import com.aydinibrahimov.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("api/category/")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        var result = categoryService.addCategory(category);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);

    }
}
