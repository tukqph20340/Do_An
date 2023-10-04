package com.example.demo.service;

import com.example.demo.entity.Product_image;
import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductImageService {
    List<Product_image> getAllProductIms();
    Product_image getProductImById(Integer id);
    void createProductIm(Product_image productIm);
    void updateProductIm(Product_image productIm);
    void deleteProductIm(Integer id);
    Page<Product_image> getAll(Pageable pageable);
    List<Product_image> searchProductIms(String keyword);
}
