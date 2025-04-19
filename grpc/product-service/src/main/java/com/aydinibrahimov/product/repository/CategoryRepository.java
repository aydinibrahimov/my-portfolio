package com.aydinibrahimov.product.repository;

import com.aydinibrahimov.product.model.Category;
import com.aydinibrahimov.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
