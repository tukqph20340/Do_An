package com.example.demo.sevice.impl;

import com.example.demo.entity.TacGia;
import com.example.demo.entity.TheLoai;
import com.example.demo.repository.TacGiaRepository;
import com.example.demo.repository.TheLoaiRepository;
import com.example.demo.sevice.TacGiaSevice;
import com.example.demo.sevice.TheLoaiSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TheLoaiSeviceImpl implements TheLoaiSevice {
    @Autowired
    TheLoaiRepository repository;

    @Override
    public List<TheLoai> getAll() {
        return repository.findAll();
    }

    @Override
    public List<TheLoai> phanTrang(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).stream().toList();
    }

    @Override
    public TheLoai delete(Integer id) {
        Optional<TheLoai> optional = repository.findById(id);
        return optional.map(theLoai -> {
            repository.delete(theLoai);
            return theLoai;
        }).orElse(null);
    }
    @Override
    public TheLoai add(TheLoai theLoai) {
        return repository.save(theLoai);
    }

    @Override
    public TheLoai update(TheLoai theLoai, Integer id) {
        Optional<TheLoai> optional = repository.findById(id);
        return optional.map(rep -> {
            rep.setTenTL(theLoai.getTenTL());
            rep.setUrlTL(theLoai.getUrlTL());
            return repository.save(rep);
        }).orElse(null);
    }

}
