package com.example.demo.service.impl;

import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository repository;

    @Override
    public List<Author> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Author> getPage(Integer pageNo, Integer size) {
        Pageable pageable =  PageRequest.of(pageNo,size);
        return repository.findAll(pageable);
    }

    @Override
    public Author detail(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Author add(Author author) {
        return repository.save(author);
    }

    @Override
    public Author update(Author author) {
        return repository.save(author);
    }
}
