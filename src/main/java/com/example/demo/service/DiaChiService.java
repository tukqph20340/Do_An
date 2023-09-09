package com.example.demo.service;

import com.example.demo.entity.DiaChi;

import java.util.List;

public interface DiaChiService {
    List<DiaChi> getAll();
    List<DiaChi> phanTrang(int page,int size);
    DiaChi add(DiaChi diaChi);
    DiaChi update(DiaChi diaChi, Integer id);
    Boolean delete(Integer id);
}
