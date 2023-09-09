package com.example.demo.service;


import com.example.demo.entity.NhaSanXuat;

import java.util.List;

public interface NhaSanXuatService {
    List<NhaSanXuat> getAll();
    List<NhaSanXuat> phanTrang(int page,int size);
    NhaSanXuat add(NhaSanXuat nhaSanXuat);
    NhaSanXuat update(NhaSanXuat nhaSanXuat,Integer id);
    Boolean delete(Integer id);
}
