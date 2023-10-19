package com.example.demo.service;


import com.example.demo.entity.Category;
import org.springframework.data.domain.Page;

import java.util.List;
public interface CategoryService {

    List<Category> getAll();

    Category save(Category category);

    Category update(Category category);

    Category getById(Integer id);

    void delete(Integer id);

    Page<Category> findPage(int pageNo , int pageSize);
}
