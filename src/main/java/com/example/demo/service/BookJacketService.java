package com.example.demo.service;

import com.example.demo.entity.BookJacket;
import org.springframework.data.domain.Page;

import java.util.List;
public interface BookJacketService {
    List<BookJacket> getAll();
    Page<BookJacket> getPage(Integer pageNo, Integer size);
    BookJacket detail(Integer id) ;
    void delete(Integer id) ;
    BookJacket add(BookJacket bookJacket);
    BookJacket update(BookJacket bookJacket);


}
