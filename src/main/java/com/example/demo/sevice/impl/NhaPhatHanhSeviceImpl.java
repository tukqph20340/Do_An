package com.example.demo.sevice.impl;


import com.example.demo.entity.NhaPhatHanh;
import com.example.demo.repository.NhaPhatHanhReopsitory;
import com.example.demo.sevice.NhaPhatHanhSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NhaPhatHanhSeviceImpl implements NhaPhatHanhSevice {
    @Autowired
    NhaPhatHanhReopsitory reopsitory;

    @Override
    public List<NhaPhatHanh> getAll() {
        return reopsitory.findAll();
    }

    @Override
    public List<NhaPhatHanh> phanTrang(int page, int size) {
        return reopsitory.findAll(PageRequest.of(page, size)).stream().toList();
        
    }

    @Override
    public NhaPhatHanh delete(Integer id) {
        Optional<NhaPhatHanh> optional = reopsitory.findById(id);
        return optional.map(nhaPhatHanh -> {
            reopsitory.delete(nhaPhatHanh);
            return nhaPhatHanh;
        }).orElse(null);
    }

    @Override
    public NhaPhatHanh add(NhaPhatHanh nhaPhatHanh) {
        return reopsitory.save(nhaPhatHanh);
    }

    @Override
    public NhaPhatHanh update(NhaPhatHanh nhaPhatHanh, Integer id) {
        Optional<NhaPhatHanh> optional = reopsitory.findById(id);
        return optional.map(rep -> {
            rep.setTenNPH(nhaPhatHanh.getTenNPH());
            rep.setDiaChiNPH(nhaPhatHanh.getDiaChiNPH());
            rep.setSdtNPH(nhaPhatHanh.getSdtNPH());
            rep.setThanhPhoNPH(nhaPhatHanh.getThanhPhoNPH());
            rep.setQuocGiaNPH(nhaPhatHanh.getQuocGiaNPH());
            rep.setEmailNPH(nhaPhatHanh.getEmailNPH());
            return reopsitory.save(rep);
        }).orElse(null);
    }
}


