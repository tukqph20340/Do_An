package com.example.demo.service;

import com.example.demo.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
    Author getAuthorById(Integer id);
    void createAuthor(Author user);
    void updateAuthor(Author user);
    void deleteAuthor(Integer id);
    Page<Author> getAll(Pageable pageable);
    List<Author> searchAuthors(String keyword);
}
