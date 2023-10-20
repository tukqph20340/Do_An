package com.example.demo.service.impl;

import com.example.demo.entity.Producer;
import com.example.demo.entity.Publisher;
import com.example.demo.repository.PublisherRepository;
import com.example.demo.service.ProducerService;
import com.example.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository res;

    @Override
    public List<Publisher> getAll() {
        return res.findAll();
    }

    @Override
    public Page<Publisher> getPage(Integer pageNo, Integer size) {
        Pageable pageable =  PageRequest.of(pageNo,size);
        return res.findAll(pageable);
    }

    @Override
    public Publisher getOne(Integer id) {
        return res.findById(id).get();
    }

    @Override
    public Publisher add(Publisher publisher) {
       Publisher add= Publisher.builder()
               .fullname(publisher.getFullname())
               .email(publisher.getEmail())
               .phone(publisher.getPhone())
               .address(publisher.getAddress())
               .country(publisher.getCountry())
               .build();

        return res.save(add);
    }

    @Override
    public Publisher update(Publisher publisher) {
        return res.save(publisher);
    }

    @Override
    public void delete(Publisher publisher) {
         res.delete(publisher);
    }
}
