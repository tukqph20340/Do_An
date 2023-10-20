package com.example.demo.service;

import com.example.demo.entity.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface PublisherService {
    List<Publisher> getAll();

    Page<Publisher> getPage(Integer pageNo, Integer size);

    Publisher getOne(Integer id);

    Publisher add(Publisher publisher);

    Publisher update(Publisher publisher);

    void delete(Publisher publisher);
}
