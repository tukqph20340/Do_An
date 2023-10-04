package com.example.demo.service.impl;

import com.example.demo.entity.Producer;
import com.example.demo.repository.ProducerRepository;
import com.example.demo.repository.PublisherRepository;
import com.example.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerRepository res;

    @Override
    public List<Producer> getAll() {
        return null;
    }

    @Override
    public Page<Producer> Page(Pageable pageable) {
        return null;
    }

    @Override
    public Producer getOne(Integer id) {
        return null;
    }

    @Override
    public Producer add(Producer producer) {
        return null;
    }

    @Override
    public Producer update(Producer producer, Integer id) {
        return null;
    }

    @Override
    public void delete(Producer producer) {

    }
}
