package com.example.demo.service;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Page<Product> Page(Pageable pageable);

    Product getOne(Integer id);

    Product add(Product product);

    Product update(Product product , Integer id);

    void delete(Product product);

    List<Product> searchProducts(String keyword);
}
