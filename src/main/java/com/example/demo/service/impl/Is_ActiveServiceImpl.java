package com.example.demo.service.impl;

import com.example.demo.entity.Is_active;
import com.example.demo.entity.Producer;
import com.example.demo.repository.Is_ActiveRepository;
import com.example.demo.repository.PublisherRepository;
import com.example.demo.service.Is_ActiveService;
import com.example.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class Is_ActiveServiceImpl implements Is_ActiveService {

    @Autowired
    private Is_ActiveRepository res;

    @Override
    public List<Is_active> getAll() {
        return res.findAll();
    }

    @Override
    public Page<Is_active> Page(Pageable pageable) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return res.findAll(pageable1);
    }

    @Override
    public Is_active getOne(Integer id) {
        return res.getReferenceById(id);
    }

    @Override
    public Is_active add(Is_active isActive) {
        Is_active add = Is_active.builder()
                .nameActive(isActive.getNameActive())
                .details(isActive.getDetails())
                .build();
        return res.save(add);
    }

    @Override
    public Is_active update(Is_active isActive, Integer id) {
        Is_active update = res.getReferenceById(id);
        update = Is_active.builder()
                .id(id)
                .nameActive(isActive.getNameActive())
                .details(isActive.getDetails())
                .build();
        return res.save(update);
    }

    @Override
    public void delete(Is_active isActive) {
        res.delete(isActive);
    }
}
