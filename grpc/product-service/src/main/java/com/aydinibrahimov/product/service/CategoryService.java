package com.aydinibrahimov.product.service;

import com.aydinibrahimov.product.model.Category;
import com.aydinibrahimov.product.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category getCategoryByid(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Category not found with id="+id));
    }
}
