package com.example.demo.service.impl;

import com.example.demo.entity.BookJacket;
import com.example.demo.repository.BookJacketRepository;
import com.example.demo.service.BookJacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookJacketServiceImpl implements BookJacketService {
    @Autowired
    BookJacketRepository repository;
    @Override
    public List<BookJacket> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<BookJacket> getPage(Integer pageNo, Integer size) {
        Pageable pageable =  PageRequest.of(pageNo,size);
        return repository.findAll(pageable);
    }

    @Override
    public BookJacket detail(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
         repository.deleteById(id);
    }

    @Override
    public BookJacket add(BookJacket bookJacket) {
        return repository.save(bookJacket);
    }

    @Override
    public BookJacket update(BookJacket bookJacket) {
        return repository.save(bookJacket);
    }
}
