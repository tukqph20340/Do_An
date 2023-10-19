package com.example.demo.service.impl;


import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepository;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart update(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getById(Integer id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Page<Cart> findPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.cartRepository.findAll(pageable);
    }
}
