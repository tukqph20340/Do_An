package com.example.demo.repository;

import com.example.demo.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StatisticRepository extends JpaRepository<Statistic,Integer> {
}
