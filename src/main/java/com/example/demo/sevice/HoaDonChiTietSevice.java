package com.example.demo.sevice;

import com.example.demo.entity.HoaDonChiTiet;

import java.util.List;
public interface HoaDonChiTietSevice {
    List<HoaDonChiTiet> getAll();
    List<HoaDonChiTiet> phanTrang(int page,int size);
    HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet);
    HoaDonChiTiet update(HoaDonChiTiet hoaDonChiTiet,Integer id);
}
