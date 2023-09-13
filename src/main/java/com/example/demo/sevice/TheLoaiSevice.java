package com.example.demo.sevice;

import com.example.demo.entity.TheLoai;

import java.util.List;
public interface TheLoaiSevice {
    List<TheLoai> getAll();
    List<TheLoai> phanTrang(int page,int size);
    TheLoai delete(Integer id);
    TheLoai add(TheLoai theLoai);
    TheLoai update(TheLoai theLoai,Integer id);

}
