package com.example.demo.sevice.impl;

import com.example.demo.entity.GioHang;
import com.example.demo.entity.HoaDon;
import com.example.demo.repository.HoaDonRepsitory;
import com.example.demo.sevice.HoaDonSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HoaDonSeviceImpl implements HoaDonSevice {
    @Autowired
    HoaDonRepsitory repsitory;

    @Override
    public List<HoaDon> getAll() {
        return repsitory.findAll();
    }

    @Override
    public List<HoaDon> phanTrang(int page, int size) {
        return repsitory.findAll(PageRequest.of(page, size)).stream().toList();
    }

    @Override
    public HoaDon add(HoaDon hoaDon) {
        return repsitory.save(hoaDon);
    }

    @Override
    public HoaDon update(HoaDon hoaDon, Integer id) {
        Optional<HoaDon> optional = repsitory.findById(id);

        return optional.map(rep -> {
            rep.setSanPham(hoaDon.getSanPham());
            rep.setNguoiDung(hoaDon.getNguoiDung());
            rep.setNgayTao(hoaDon.getNgayTao());
            rep.setNgayThanhToan(hoaDon.getNgayThanhToan());
            rep.setNgayHuy(hoaDon.getNgayHuy());
            rep.setTinhTrang(hoaDon.getTinhTrang());
            return repsitory.save(rep);
        }).orElse(null);
    }
}
