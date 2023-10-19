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
    private ProductImageRepository repository;

    @Override
    public List<Product_image> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Product_image> getPage(Integer pageNo, Integer size) {
        Pageable pageable =  PageRequest.of(pageNo,size);
        return repository.findAll(pageable);
    }

    @Override
    public Product_image detail(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Product_image add(Product_image product_image) {
        return repository.save(product_image);
    }

    @Override
    public Product_image update(Product_image product_image) {
        return repository.save(product_image);
    }
}
