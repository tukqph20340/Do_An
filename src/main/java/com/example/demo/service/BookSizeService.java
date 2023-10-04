package com.example.demo.service;

import com.example.demo.entity.BookSize;
import org.springframework.data.domain.Page;

import java.util.List;
public interface BookSizeService {
    List<BookSize> getAll();
    Page<BookSize> getPage(Integer pageNo, Integer size);
    BookSize detail(Integer id) ;
    void delete(Integer id) ;
    BookSize add(BookSize bookSize);
    BookSize update(BookSize bookSize);


}
