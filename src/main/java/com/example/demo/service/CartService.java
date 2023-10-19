package com.example.demo.service;


import com.example.demo.entity.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface CartService {

    List<Cart> getAll();

    Cart save(Cart cart);

    Cart update(Cart cart);

    Cart getById(Integer id);

    void delete(Integer id);

    Page<Cart> findPage(int pageNo , int pageSize);
}
