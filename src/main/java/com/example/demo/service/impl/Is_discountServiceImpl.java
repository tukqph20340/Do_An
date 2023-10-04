package com.example.demo.service.impl;

import com.example.demo.entity.Is_discount;
import com.example.demo.entity.Producer;
import com.example.demo.repository.Is_discountRepository;
import com.example.demo.repository.PublisherRepository;
import com.example.demo.service.Is_discountService;
import com.example.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class Is_discountServiceImpl implements Is_discountService {

    @Autowired
    private Is_discountRepository res;

    @Override
    public List<Is_discount> getAll() {
        return null;
    }

    @Override
    public Page<Is_discount> Page(Pageable pageable) {
        return null;
    }

    @Override
    public Is_discount getOne(Integer id) {
        return null;
    }

    @Override
    public Is_discount add(Is_discount isDiscount) {
        return null;
    }

    @Override
    public Is_discount update(Is_discount isDiscount, Integer id) {
        return null;
    }

    @Override
    public void delete(Is_discount isDiscount) {

    }
}
