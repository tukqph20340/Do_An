package com.example.demo.sevice;

import com.example.demo.entity.GioHang;

import java.util.List;
import java.util.Optional;
public interface GioHangSevice {
    List<GioHang> getAll();
    List<GioHang> phanTrang(int page,int size);
    GioHang add(GioHang gioHang);
    GioHang update(GioHang gioHang,Integer id);
}
