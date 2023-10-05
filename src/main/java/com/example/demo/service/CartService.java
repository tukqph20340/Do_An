package com.example.demo.service;


import com.example.demo.entity.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface CartService {

    List<Cart> getAll();

    Page<Cart> getAll(Pageable pageable);

    Cart save(Cart cart);

    Cart update(Cart cart);

    void delete(Integer id);

}
