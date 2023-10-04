package com.example.demo.repository;

import com.example.demo.entity.BookJacket;
import com.example.demo.entity.BookSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookSizeRepository extends JpaRepository<BookSize,Integer> {
}
