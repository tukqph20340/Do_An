package com.example.demo.service.impl;

import com.example.demo.entity.Product_image;
import com.example.demo.repository.ProductImageRepository;
import com.example.demo.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    private ProductImageRepository res;

    @Override
    public List<Product_image> getAll() {
        return res.findAll();
    }

    @Override
    public Page<Product_image> Page(Pageable pageable) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return res.findAll(pageable1);
    }

    @Override
    public Product_image getOne(Integer id) {
        return res.findById(id).get();
    }

    @Override
    public Product_image add(Product_image product_image) {
        Product_image add = Product_image.builder()
                .imageUrl(product_image.getImageUrl())
                .build();
        return res.save(add);
    }

    @Override
    public Product_image update(Product_image product_image, Integer id) {
        Product_image update = res.getReferenceById(id);
        update = Product_image.builder()
                .id(id)
                .imageUrl(product_image.getImageUrl())
                .build();
        return res.save(update);
    }

    @Override
    public void delete(Product_image product_image) {
        res.delete(product_image);
    }

    @Override
    public List<Product_image> searchProductImages(String keyword) {
        return res.search(keyword);
    }
}
