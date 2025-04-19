package com.aydinibrahimov.product.service;

import com.aydinibrahimov.product.model.Product;
import com.aydinibrahimov.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;


    public Product addProduct(Product product) {
        categoryService.getCategoryByid(product.getCategory().getId());
        var newProduct = productRepository.save(product);
        return newProduct;
    }

    public Product getProductById(Long id) {
        return findProductById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Long id, Product newProduct) {
        var product = findProductById(id);
        product.setDescription(newProduct.getDescription());
        productRepository.save(product);
        return product;
    }


    private Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id=" + id));


    }
}
