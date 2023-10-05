package com.example.demo.service;


import com.example.demo.entity.OrderrItem;

import java.util.List;
public interface OrderrItemService {

    List<OrderrItem> getAll();

    OrderrItem save(OrderrItem orderrItem);

    OrderrItem update(OrderrItem orderrItem);

    void delete(Integer id);
}
