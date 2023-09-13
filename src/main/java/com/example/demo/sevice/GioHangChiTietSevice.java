package com.example.demo.sevice;

import com.example.demo.entity.GioHangChiTiet;

import java.util.List;
public interface GioHangChiTietSevice {
    List<GioHangChiTiet> getAll();
    List<GioHangChiTiet> phanTrang(int page,int size);
    GioHangChiTiet add(GioHangChiTiet gioHangChiTiet);
    GioHangChiTiet update(GioHangChiTiet gioHangChiTiet,Integer id);
}
