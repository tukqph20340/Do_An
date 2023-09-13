package com.example.demo.sevice;

import com.example.demo.entity.Anh;

import java.util.List;
public interface AnhSevice {
    List<Anh> getAll();
    List<Anh> phanTrang(int page,int size);
    Anh delete(Integer id);
    Anh add(Anh anh);
    Anh update(Anh anh,Integer id);
}
