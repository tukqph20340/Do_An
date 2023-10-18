package com.example.demo.service;

import com.example.demo.entity.Product_image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductImageService {
    List<Product_image> getAll();

    Page<Product_image> Page(Pageable pageable);

    Product_image getOne(Integer id);

    Product_image add(Product_image product_image);

    Product_image update(Product_image product_image , Integer id);

    void delete(Product_image product_image);

    List<Product_image> searchProductImages(String keyword);
}
