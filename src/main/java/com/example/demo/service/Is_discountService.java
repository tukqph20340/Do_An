package com.example.demo.service;

import com.example.demo.entity.Is_discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface Is_discountService {
    List<Is_discount> getAll();

    Page<Is_discount> Page(Pageable pageable);

    Is_discount getOne(Integer id);

    Is_discount add(Is_discount isDiscount);

    Is_discount update(Is_discount isDiscount , Integer id);

    void delete(Is_discount isDiscount);
}
