package com.example.demo.service;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Integer id);
    void createProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Integer id);
    Page<Product> getAll(Pageable pageable);
    List<Product> searchProducts(String keyword);
}
