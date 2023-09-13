package com.example.demo.sevice.impl;


import com.example.demo.entity.TacGia;
import com.example.demo.repository.TacGiaRepository;
import com.example.demo.sevice.TacGiaSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TacGiaSeviceImpl implements TacGiaSevice {
    @Autowired
    TacGiaRepository repsitory;
    @Override
    public List<TacGia> getAll() {
        return repsitory.findAll();
    }

    @Override
    public List<TacGia> phanTrang(int page, int size) {
        return repsitory.findAll(PageRequest.of(page, size)).stream().toList();
    }

    @Override
    public TacGia delete(Integer id) {
        Optional<TacGia> optional = repsitory.findById(id);
        return optional.map(tacGia -> {
            repsitory.delete(tacGia);
            return tacGia;
        }).orElse(null);
    }

    @Override
    public TacGia add(TacGia tacGia) {
        return repsitory.save(tacGia);
    }

    @Override
    public TacGia update(TacGia tacGia, Integer id) {
        Optional<TacGia> optional = repsitory.findById(id);
        return optional.map(rep -> {
            rep.setHoTG(tacGia.getHoTG());
            rep.setTenDemTG(tacGia.getTenDemTG());
            rep.setTenTG(tacGia.getTenTG());
            rep.setDiaChiTG(tacGia.getDiaChiTG());
            rep.setSdtTG(tacGia.getSdtTG());
            rep.setGioiTinhTG(tacGia.getGioiTinhTG());
            rep.setNgaySinhTG(tacGia.getNgaySinhTG());
            return repsitory.save(rep);
        }).orElse(null);
    }
}
