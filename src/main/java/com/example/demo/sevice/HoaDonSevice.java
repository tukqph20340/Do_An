package com.example.demo.sevice;

import com.example.demo.entity.GioHang;
import com.example.demo.entity.HoaDon;

import java.util.List;
public interface HoaDonSevice {
    List<HoaDon> getAll();
    List<HoaDon> phanTrang(int page,int size);
    HoaDon add(HoaDon HoaDon);
    HoaDon update(HoaDon HoaDon,Integer id);
}
