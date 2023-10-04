package com.example.demo.service;

import com.example.demo.entity.Statistic;
import org.springframework.data.domain.Page;

import java.util.List;
public interface StatisticService {
    List<Statistic> getAll();
    Page<Statistic> getPage(Integer pageNo, Integer size);
    Statistic detail(Integer id) ;
    void delete(Integer id) ;
    Statistic add(Statistic statistic);
    Statistic update(Statistic statistic);


}
