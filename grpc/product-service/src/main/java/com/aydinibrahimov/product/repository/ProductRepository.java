package com.aydinibrahimov.product.repository;

import com.aydinibrahimov.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
