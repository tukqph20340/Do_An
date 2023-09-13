package com.example.demo.service;

import com.example.demo.entity.BanQuyen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface BanQuyenSerivce {
    List<BanQuyen> getAll();
    Page<BanQuyen> phanTrang(Pageable pageable);
    BanQuyen add(BanQuyen banQuyen);
    BanQuyen detail(Integer id);
    BanQuyen update(BanQuyen banQuyen,Integer id);
    void delete(Integer id);
}