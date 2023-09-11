package com.example.demo.service;

import com.example.demo.entity.NguoiDung;

import java.util.List;

public interface NguoiDungService {
    List<NguoiDung> getAll();
    List<NguoiDung> phanTrang(int page,int size);
    NguoiDung add(NguoiDung nguoiDung);
    NguoiDung update(NguoiDung nguoiDung,Integer id);
    Boolean delete(Integer id);
}
