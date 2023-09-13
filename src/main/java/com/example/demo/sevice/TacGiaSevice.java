package com.example.demo.sevice;

import com.example.demo.entity.TacGia;

import java.util.List;
public interface TacGiaSevice {
    List<TacGia> getAll();
    List<TacGia> phanTrang(int page,int size);
    TacGia delete(Integer id);
    TacGia add(TacGia tacGia);
    TacGia update(TacGia tacGia,Integer id);
}
