package com.example.demo.service;

import com.example.demo.entity.Bia;
import com.example.demo.entity.KhuyenMai;

import java.util.List;

public interface KhuyenMaiService {

    List<KhuyenMai> getAll();

    KhuyenMai save(KhuyenMai khuyenMai);

    KhuyenMai update(KhuyenMai khuyenMai);

    void delete(Integer id);
}
