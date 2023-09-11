package com.example.demo.service.impl;

import com.example.demo.entity.DiaChi;
import com.example.demo.repository.DiaChiRepository;
import com.example.demo.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiaChiServiceImpl implements DiaChiService {
    @Autowired
    DiaChiRepository repository;

    @Override
    public List<DiaChi> getAll() {
        return repository.findAll();
    }

    @Override
    public List<DiaChi> phanTrang(int page, int size) {
        return repository.findAll(PageRequest.of(page,size)).stream().toList();
    }

    @Override
    public DiaChi add(DiaChi diaChi) {
        return repository.save(diaChi);
    }

    public Boolean delete(Integer id){
        Optional<DiaChi> optional = repository.findById(id);
        if (optional.isPresent()){
            DiaChi diaChi = optional.get();
            repository.delete(diaChi);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public DiaChi update(DiaChi diaChi, Integer id) {
        Optional<DiaChi> optional = repository.findById(id);
        return optional.map(rep -> {
            rep.setNguoiDung(diaChi.getNguoiDung());
            rep.setTenDC(diaChi.getTenDC());
            rep.setSdtDC(diaChi.getSdtDC());
            rep.setDiaChiDC(diaChi.getDiaChiDC());
            rep.setThanhPhoDC(diaChi.getThanhPhoDC());
            rep.setQuocGiaDC(diaChi.getQuocGiaDC());
            return repository.save(rep);
        }).orElse(null);
    }
}
