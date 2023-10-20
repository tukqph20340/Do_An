package com.example.demo.service;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Page;
import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Page<Product> getPage(Integer pageNo, Integer size);

    Product detail(Integer id) ;

    void delete(Integer id) ;

    Product add(Product product);

    Product update(Product product);
}
