package com.example.demo.repository;

import com.example.demo.entity.TacGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TacGiaRepository extends JpaRepository<TacGia,Integer> {
}
