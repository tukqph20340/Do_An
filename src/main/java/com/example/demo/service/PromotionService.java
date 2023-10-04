package com.example.demo.service;

import com.example.demo.entity.Promotion;
import org.springframework.data.domain.Page;

import java.util.List;
public interface PromotionService {
    List<Promotion> getAll();
    Page<Promotion> getPage(Integer pageNo, Integer size);
    Promotion detail(Integer id) ;
    void delete(Integer id) ;
    Promotion add(Promotion promotion);
    Promotion update(Promotion promotion);


}
