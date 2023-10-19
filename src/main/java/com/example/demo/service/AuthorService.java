package com.example.demo.service;

import com.example.demo.entity.Author;
import org.springframework.data.domain.Page;
import java.util.List;

public interface AuthorService {
    List<Author> getAll();

    Page<Author> getPage(Integer pageNo, Integer size);

    Author detail(Integer id) ;

    void delete(Integer id) ;

    Author add(Author author);

    Author update(Author author);
}
