package com.example.demo.service.impl;


import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderrItemServiceImpl implements OrderrItemService {

    @Autowired
    private OrderrItemRepository orderrItemRepository;


    @Override
    public List<OrderrItem> getAll() {
        return orderrItemRepository.findAll();
    }

    @Override
    public OrderrItem save(OrderrItem orderrItem) {
        return orderrItemRepository.save(orderrItem);
    }

    @Override
    public OrderrItem update(OrderrItem orderrItem) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        orderrItemRepository.deleteById(id);
    }
}
