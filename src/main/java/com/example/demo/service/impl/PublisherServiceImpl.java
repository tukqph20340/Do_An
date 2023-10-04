package com.example.demo.service.impl;

import com.example.demo.entity.Producer;
import com.example.demo.entity.Publisher;
import com.example.demo.repository.PublisherRepository;
import com.example.demo.service.ProducerService;
import com.example.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public Page<Publisher> Page(Pageable pageable) {
        return res.findAll(pageable);
    }

    @Override
    public Publisher getOne(Integer id) {
        return res.getReferenceById(id);
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
    public Publisher update(Publisher publisher, Integer id) {
        Publisher update = res.getReferenceById(id);
        update= Publisher.builder()
                .id(id)
                .fullname(publisher.getFullname())
                .email(publisher.getEmail())
                .phone(publisher.getPhone())
                .address(publisher.getAddress())
                .country(publisher.getCountry())
                .build();
        return res.save(update);
    }

    @Override
    public void delete(Publisher publisher) {
         res.delete(publisher);
    }
}
