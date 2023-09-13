package com.example.demo.service.impl;

import com.example.demo.controller.BanQuyenController;
import com.example.demo.entity.BanQuyen;
import com.example.demo.repository.BanQuyenRepository;
import com.example.demo.service.BanQuyenSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BanQuyenServiceiplm implements BanQuyenSerivce {
    @Autowired
    BanQuyenRepository controller;
    @Override
    public List<BanQuyen> getAll() {
        return controller.findAll();
    }

    @Override
    public Page<BanQuyen> phanTrang(Pageable pageable) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return controller.findAll(pageable1);
    }

    @Override
    public BanQuyen add(BanQuyen banQuyen) {
        return controller.save(banQuyen);
    }

    @Override
    public BanQuyen detail(Integer id) {
        return controller.getReferenceById(id);
    }

    @Override
    public BanQuyen update(BanQuyen banQuyen, Integer id) {
        BanQuyen bq = controller.getReferenceById(id);
        bq.setSanPham(banQuyen.getSanPham());
        bq.setNgayDangKy(banQuyen.getNgayDangKy());
        bq.setNgayCap(banQuyen.getNgayCap());
        bq.setNgayHetHan(banQuyen.getNgayHetHan());
        bq.setTrangThai(banQuyen.getTrangThai());
       return controller.save(bq);
    }

    @Override
    public void delete(Integer id) {
         controller.deleteById(id);
    }
}
