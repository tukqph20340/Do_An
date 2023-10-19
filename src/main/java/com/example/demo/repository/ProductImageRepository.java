package com.example.demo.repository;

import com.example.demo.entity.Product_image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<Product_image, Integer> {
}
