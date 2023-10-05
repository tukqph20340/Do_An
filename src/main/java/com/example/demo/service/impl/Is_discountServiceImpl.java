package com.example.demo.service.impl;

import com.example.demo.entity.Is_discount;
import com.example.demo.entity.Producer;
import com.example.demo.repository.Is_discountRepository;
import com.example.demo.repository.PublisherRepository;
import com.example.demo.service.Is_discountService;
import com.example.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class Is_discountServiceImpl implements Is_discountService {

    @Autowired
    private Is_discountRepository res;

    @Override
    public List<Is_discount> getAll() {
        return res.findAll();
    }

    @Override
    public Page<Is_discount> Page(Pageable pageable) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return res.findAll(pageable1);
    }

    @Override
    public Is_discount getOne(Integer id) {
        return res.getReferenceById(id);
    }

    @Override
    public Is_discount add(Is_discount isDiscount) {
        Is_discount add = Is_discount.builder()
                .nameSale(isDiscount.getNameSale())
                .createDate(isDiscount.getCreateDate())
                .firstDate(isDiscount.getFirstDate())
                .lastDate(isDiscount.getLastDate())
                .percentDecrease(isDiscount.getPercentDecrease())
                .codeDiscount(isDiscount.getCodeDiscount())
                .describing((isDiscount.getDescribing()))
                .isActive(isDiscount.getIsActive())
                .build();
        return res.save(add);
    }

    @Override
    public Is_discount update(Is_discount isDiscount, Integer id) {
        Is_discount add = res.getReferenceById(id);
        add = Is_discount.builder()
                .id(id)
                .nameSale(isDiscount.getNameSale())
                .createDate(isDiscount.getCreateDate())
                .firstDate(isDiscount.getFirstDate())
                .lastDate(isDiscount.getLastDate())
                .percentDecrease(isDiscount.getPercentDecrease())
                .codeDiscount(isDiscount.getCodeDiscount())
                .describing((isDiscount.getDescribing()))
                .isActive(isDiscount.getIsActive())
                .build();
        return res.save(add);
    }

    @Override
    public void delete(Is_discount isDiscount) {
        res.delete(isDiscount);
    }
}
