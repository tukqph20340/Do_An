package com.example.demo.service.impl;

import com.example.demo.entity.Product_image;
import com.example.demo.repository.ProductImageRepository;
import com.example.demo.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public List<Product_image> getAllProductIms() {
        return productImageRepository.findAll();
    }

    @Override
    public Product_image getProductImById(Integer id) {
        return productImageRepository.findById(id).orElse(null);
    }

    @Override
    public void createProductIm(Product_image productIm) {
        productImageRepository.save(productIm);
    }

    @Override
    public void updateProductIm(Product_image productIm) {
        productImageRepository.save(productIm);
    }

    @Override
    public void deleteProductIm(Integer id) {
        productImageRepository.deleteById(id);
    }

    @Override
    public Page<Product_image> getAll(Pageable pageable) {
        return productImageRepository.findAll(pageable);
    }

    @Override
    public List<Product_image> searchProductIms(String keyword) {
        return productImageRepository.findByImageUrl(keyword);
    }
}
