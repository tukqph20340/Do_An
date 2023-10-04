package com.example.demo.service.impl;

import com.example.demo.entity.Promotion;
import com.example.demo.repository.PromotionRepository;
import com.example.demo.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    PromotionRepository repository;
    @Override
    public List<Promotion> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Promotion> getPage(Integer pageNo, Integer size) {
        Pageable pageable =  PageRequest.of(pageNo,size);
        return repository.findAll(pageable);
    }

    @Override
    public Promotion detail(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
         repository.deleteById(id);
    }

    @Override
    public Promotion add(Promotion promotion) {
        return repository.save(promotion);
    }

    @Override
    public Promotion update(Promotion promotion) {
        return repository.save(promotion);
    }
}
