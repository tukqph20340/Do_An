package com.example.demo.service.impl;

import com.example.demo.entity.Producer;
import com.example.demo.repository.ProducerRepository;
import com.example.demo.repository.PublisherRepository;
import com.example.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        return res.findAll();
    }

    @Override
    public Page<Producer> getPage(Integer pageNo, Integer size){
        Pageable pageable =  PageRequest.of(pageNo,size);
        return res.findAll(pageable);
    }

    @Override
    public Producer getOne(Integer id) {
        return res.findById(id).get();
    }

    @Override
    public Producer add(Producer producer) {
        Producer add = Producer.builder()
                .fullname(producer.getFullname())
                .email(producer.getEmail())
                .phone(producer.getPhone())
                .address(producer.getAddress())
                .country(producer.getCountry())
                .build();
        return res.save(add);
    }

    @Override
    public Producer update(Producer producer) {
        return res.save(producer);
    }

    @Override
    public void delete(Producer producer) {
        res.delete(producer);
    }
}
