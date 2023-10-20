package com.example.demo.service;

import com.example.demo.entity.Product_image;
import org.springframework.data.domain.Page;
import java.util.List;

public interface ProductImageService {
    List<Product_image> getAll();

    Page<Product_image> getPage(Integer pageNo, Integer size);

    Product_image detail(Integer id) ;

    void delete(Integer id) ;

    Product_image add(Product_image product_image);

    Product_image update(Product_image product_image);
}
