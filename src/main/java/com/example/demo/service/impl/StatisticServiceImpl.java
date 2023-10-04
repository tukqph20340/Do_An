package com.example.demo.service.impl;

import com.example.demo.entity.Statistic;
import com.example.demo.repository.StatisticRepository;
import com.example.demo.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    StatisticRepository repository;
    @Override
    public List<Statistic> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Statistic> getPage(Integer pageNo, Integer size) {
        Pageable pageable =  PageRequest.of(pageNo,size);
        return repository.findAll(pageable);
    }

    @Override
    public Statistic detail(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
         repository.deleteById(id);
    }

    @Override
    public Statistic add(Statistic statistic) {
        return repository.save(statistic);
    }

    @Override
    public Statistic update(Statistic statistic) {
        return repository.save(statistic);
    }
}
