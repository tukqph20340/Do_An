package com.example.demo.repository;

import com.example.demo.entity.Product_image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<Product_image, Integer> {
    @Query("SELECT p FROM Product_image p WHERE p.imageUrl LIKE %:keyword%")
    List<Product_image> search(@Param("keyword") String keyword);
}
