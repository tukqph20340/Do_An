package com.example.demo.repository;

import com.example.demo.entity.Promotion;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface PromotionRepository extends JpaRepository<Promotion,Integer> {
    List<Promotion> findByCoup_code(String code);
}
