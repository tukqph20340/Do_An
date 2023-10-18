package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository res;

    @Override
    public List<Product> getAll() {
        return res.findAll();
    }

    @Override
    public Page<Product> Page(Pageable pageable) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return res.findAll(pageable1);
    }

    @Override
    public Product getOne(Integer id) {
        return res.findById(id).get();
    }

    @Override
    public Product add(Product product) {
        Product add = Product.builder()
                .createdAt(product.getCreatedAt())
                .description(product.getDescription())
                .isActive(product.getIsActive())
                .isSelling(product.getIsSelling())
                .price(product.getPrice())
                .productName(product.getProductName())
                .quantity(product.getQuantity())
                .sold(product.getSold())
                .build();
        return res.save(add);
    }

    @Override
    public Product update(Product product, Integer id) {
        Product update = res.getReferenceById(id);
        update = Product.builder()
                .id(id)
                .createdAt(product.getCreatedAt())
                .description(product.getDescription())
                .isActive(product.getIsActive())
                .isSelling(product.getIsSelling())
                .price(product.getPrice())
                .productName(product.getProductName())
                .quantity(product.getQuantity())
                .sold(product.getSold())
                .build();
        return res.save(update);
    }

    @Override
    public void delete(Product product) {
        res.delete(product);
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        return res.search(keyword);
    }
}
