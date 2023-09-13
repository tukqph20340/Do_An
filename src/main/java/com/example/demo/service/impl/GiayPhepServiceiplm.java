package com.example.demo.service.impl;

import com.example.demo.entity.GiayPhep;
import com.example.demo.repository.GiayPhepRepository;
import com.example.demo.service.GiayPhepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GiayPhepServiceiplm implements GiayPhepService {
    @Autowired
    GiayPhepRepository res;
    @Override
    public List<GiayPhep> getAll() {
        return res.findAll();
    }

    @Override
    public Page<GiayPhep> phanTrang(Pageable pageable) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return res.findAll(pageable1);
    }

    @Override
    public GiayPhep add(GiayPhep giayPhep) {
        return res.save(giayPhep);
    }

    @Override
    public GiayPhep detail(Integer id) {
        return res.getReferenceById(id);
    }

    @Override
    public GiayPhep update(GiayPhep giayPhep, Integer id) {
        GiayPhep gp = res.getReferenceById(id);
        gp.setSoGiayPhep(giayPhep.getSoGiayPhep());
        gp.setNgayCap(giayPhep.getNgayCap());
        gp.setNgayHetHan(giayPhep.getNgayHetHan());
        gp.setNguoiCap(giayPhep.getNguoiCap());
        gp.setTrangThai(giayPhep.getTrangThai());
        return res.save(gp);
    }

    @Override
    public void delete(Integer id) {
        res.deleteById(id);
    }
}
