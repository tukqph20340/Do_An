package com.example.demo.repository;

import com.example.demo.entity.Anh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AnhRepsitory extends JpaRepository<Anh,Integer> {
}
