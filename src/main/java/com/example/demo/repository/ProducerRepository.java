package com.example.demo.repository;

import com.example.demo.entity.Producer;
import com.example.demo.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer,Integer> {
}
