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
    private AuthorRepository res;

    @Override
    public List<Author> getAll() {
        return res.findAll();
    }

    @Override
    public Page<Author> Page(Pageable pageable) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return res.findAll(pageable1);
    }

    @Override
    public Author getOne(Integer id) {
        return res.findById(id).get();
    }

    @Override
    public Author add(Author author) {
        Author add = Author.builder()
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .build();
        return res.save(add);
    }

    @Override
    public Author update(Author author, Integer id) {
        Author update = res.getReferenceById(id);
        update = Author.builder()
                .id(id)
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .build();
        return res.save(update);
    }

    @Override
    public void delete(Author author) {
        res.delete(author);
    }

    @Override
    public List<Author> searchAuthors(String keyword) {
        return res.search(keyword);
    }
}
