package com.example.demo.service;

import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.SanPham;

import java.util.List;

public interface SanPhamService {

    List<SanPham> getAll();

    SanPham save(SanPham sanPham);

    SanPham update(SanPham sanPham);

    void delete(Integer id);
}
