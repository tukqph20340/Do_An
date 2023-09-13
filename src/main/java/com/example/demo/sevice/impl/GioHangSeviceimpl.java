package com.example.demo.sevice.impl;

import com.example.demo.entity.GioHang;
import com.example.demo.entity.NguoiDung;
import com.example.demo.repository.GioHangRepository;
import com.example.demo.sevice.GioHangSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class GioHangSeviceimpl implements GioHangSevice {
    @Autowired
    GioHangRepository repository;
    @Override
    public List<GioHang> getAll() {
        return repository.findAll();
    }

    @Override
    public List<GioHang> phanTrang(int page, int size) {
        return repository.findAll(PageRequest.of(page,size)).stream().toList();
    }



    @Override
    public GioHang add(GioHang gioHang) {
        return repository.save(gioHang);
    }

    @Override
    public GioHang update(GioHang gioHang,Integer id) {
        Optional<GioHang> optional = repository.findById(id);

        return optional.map(rep -> {
            rep.setNguoiDung(gioHang.getNguoiDung());
            rep.setNgayTao(gioHang.getNgayTao());
            rep.setTrangThai(gioHang.getTrangThai());
            return repository.save(rep);
        }).orElse(null);
    }
}
