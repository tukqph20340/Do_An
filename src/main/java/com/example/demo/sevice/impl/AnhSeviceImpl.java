package com.example.demo.sevice.impl;

import com.example.demo.entity.Anh;
import com.example.demo.entity.NhaPhatHanh;
import com.example.demo.repository.AnhRepsitory;
import com.example.demo.sevice.AnhSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AnhSeviceImpl implements AnhSevice {
    @Autowired
    AnhRepsitory repsitory;
    @Override
    public List<Anh> getAll() {
        return repsitory.findAll();
    }

    @Override
    public List<Anh> phanTrang(int page, int size) {
        return repsitory.findAll(PageRequest.of(page, size)).stream().toList();
    }

    @Override
    public Anh delete(Integer id) {
        Optional<Anh> optional = repsitory.findById(id);
        return optional.map(anh -> {
            repsitory.delete(anh);
            return anh;
        }).orElse(null);
    }

    @Override
    public Anh add(Anh anh) {
        return repsitory.save(anh);
    }

    @Override
    public Anh update(Anh anh, Integer id) {
        Optional<Anh> optional = repsitory.findById(id);
        return optional.map(rep -> {
            rep.setTenAnh(anh.getTenAnh());
            rep.setUrlAnh(anh.getUrlAnh());
            return repsitory.save(rep);
        }).orElse(null);
    }
    }

