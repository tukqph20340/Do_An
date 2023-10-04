package com.example.demo.repository;

import com.example.demo.entity.BookJacket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookJacketRepository extends JpaRepository<BookJacket,Integer> {
}
