package com.example.demo.service;

import com.example.demo.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();

    Page<Author> Page(Pageable pageable);

    Author getOne(Integer id);

    Author add(Author author);

    Author update(Author author , Integer id);

    void delete(Author author);

    List<Author> searchAuthors(String keyword);
}
