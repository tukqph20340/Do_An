package com.example.demo.service;

import com.example.demo.entity.GiayPhep;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GiayPhepService {
    List<GiayPhep> getAll();

    Page<GiayPhep> phanTrang(Pageable pageable);

    GiayPhep add(GiayPhep giayPhep);

    GiayPhep detail(Integer id);

    GiayPhep update(GiayPhep giayPhep, Integer id);

    void delete(Integer id);
}
