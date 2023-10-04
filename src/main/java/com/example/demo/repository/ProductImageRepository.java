package com.example.demo.repository;

import com.example.demo.entity.Product_image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<Product_image, Integer> {
    List<Product_image> findByImageUrl(String keyword);
}
