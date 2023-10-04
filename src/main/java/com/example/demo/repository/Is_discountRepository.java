package com.example.demo.repository;

import com.example.demo.entity.Is_discount;
import com.example.demo.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Is_discountRepository extends JpaRepository<Is_discount,Integer> {
}
