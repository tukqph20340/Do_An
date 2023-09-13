package com.example.demo.sevice.impl;

import com.example.demo.entity.GioHangChiTiet;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.repository.HoaDonChiTietRepository;
import com.example.demo.sevice.HoaDonChiTietSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HoaDonChiTietSeviceImpl implements HoaDonChiTietSevice {
    @Autowired
    HoaDonChiTietRepository repository;
    @Override
    public List<HoaDonChiTiet> getAll() {
        return repository.findAll();
    }

    @Override
    public List<HoaDonChiTiet> phanTrang(int page, int size) {
        return repository.findAll(PageRequest.of(page,size)).stream().toList();
    }

    @Override
    public HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet) {
        return repository.save(hoaDonChiTiet);
    }

    @Override
    public HoaDonChiTiet update(HoaDonChiTiet hoaDonChiTiet, Integer id) {
        Optional<HoaDonChiTiet> optional = repository.findById(id);
        return optional.map(rep -> {
            rep.setSanPham(hoaDonChiTiet.getSanPham());
            rep.setSoLuong(hoaDonChiTiet.getSoLuong());
            rep.setTongGia(hoaDonChiTiet.getTongGia());
            rep.setTinhTrang(hoaDonChiTiet.getTinhTrang());
            return repository.save(rep);
        }).orElse(null);
    }
}
