package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderrServiceImpl implements OrderrService {

    @Autowired
    public OrderrRepository orderrRepository;

    @Override
    public List<Orderr> getAll() {
        return orderrRepository.findAll();
    }

    @Override
    public Orderr save(Orderr orderr) {
        return orderrRepository.save(orderr);
    }

    @Override
    public Orderr update(Orderr orderr) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        orderrRepository.deleteById(id);
    }
}
