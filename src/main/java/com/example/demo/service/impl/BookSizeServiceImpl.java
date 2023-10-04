package com.example.demo.service.impl;

import com.example.demo.entity.BookSize;
import com.example.demo.repository.BookSizeRepository;
import com.example.demo.service.BookSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSizeServiceImpl implements BookSizeService {
    @Autowired
    BookSizeRepository repository;
    @Override
    public List<BookSize> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<BookSize> getPage(Integer pageNo, Integer size) {
        Pageable pageable =  PageRequest.of(pageNo,size);
        return repository.findAll(pageable);
    }

    @Override
    public BookSize detail(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
         repository.deleteById(id);
    }

    @Override
    public BookSize add(BookSize bookSize) {
        return repository.save(bookSize);
    }

    @Override
    public BookSize update(BookSize bookSize) {
        return repository.save(bookSize);
    }
}
