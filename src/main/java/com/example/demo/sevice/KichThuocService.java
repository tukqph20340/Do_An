package com.example.demo.service;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.entity.KichThuoc;

import java.util.List;

public interface KichThuocService {

    List<KichThuoc> getAll();

    KichThuoc save(KichThuoc kichThuoc);

    KichThuoc update(KichThuoc kichThuoc);

    void delete(Integer id);
}
