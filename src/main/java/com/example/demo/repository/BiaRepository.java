package com.example.demo.repository;

import com.example.demo.entity.Bia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiaRepository extends JpaRepository<Bia, Integer> {
}
