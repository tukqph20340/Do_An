package com.example.demo.service;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.NguoiDung;

import java.util.List;

public interface ChucVuService {
    List<ChucVu> getAll();
    List<ChucVu> phanTrang(int page,int size);
    ChucVu add(ChucVu chucVu);
    ChucVu update(ChucVu chucVu,Integer id);
    Boolean delete(Integer id);
}
