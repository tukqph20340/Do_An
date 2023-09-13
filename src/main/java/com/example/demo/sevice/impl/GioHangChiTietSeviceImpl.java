package com.example.demo.sevice.impl;

import com.example.demo.entity.GioHang;
import com.example.demo.entity.GioHangChiTiet;
import com.example.demo.repository.GioHangChiTietRepository;
import com.example.demo.sevice.GioHangChiTietSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GioHangChiTietSeviceImpl implements GioHangChiTietSevice {
    @Autowired
    GioHangChiTietRepository repository;
    @Override
    public List<GioHangChiTiet> getAll() {
        return repository.findAll();
    }

    @Override
    public List<GioHangChiTiet> phanTrang(int page, int size) {
        return repository.findAll(PageRequest.of(page,size)).stream().toList();
    }

    @Override
    public GioHangChiTiet add(GioHangChiTiet gioHangChiTiet) {
        return repository.save(gioHangChiTiet);
    }

    @Override
    public GioHangChiTiet update(GioHangChiTiet gioHangChiTiet, Integer id) {
        Optional<GioHangChiTiet> optional = repository.findById(id);
        return optional.map(rep -> {
            rep.setSanPham(gioHangChiTiet.getSanPham());
            rep.setDiaChi(gioHangChiTiet.getDiaChi());
            rep.setSoLuong(gioHangChiTiet.getSoLuong());
            rep.setTongGia(gioHangChiTiet.getTongGia());
            rep.setTinhTrang(gioHangChiTiet.getTinhTrang());
            return repository.save(rep);
        }).orElse(null);
    }
}
