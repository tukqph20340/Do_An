package com.example.demo.service.impl;

import com.example.demo.entity.NguoiDung;
import com.example.demo.repository.NguoiDungRepository;
import com.example.demo.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {
    @Autowired
    NguoiDungRepository repository;

    @Override
    public List<NguoiDung> getAll() {
        return repository.findAll();
    }

    @Override
    public List<NguoiDung> phanTrang(int page, int size) {
        return repository.findAll(PageRequest.of(page,size)).stream().toList();
    }

    @Override
    public NguoiDung add(NguoiDung nguoiDung) {
        return repository.save(nguoiDung);
    }

    public Boolean delete(Integer id){
        Optional<NguoiDung> optional = repository.findById(id);
        if (optional.isPresent()){
            NguoiDung nguoiDung = optional.get();
            repository.delete(nguoiDung);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public NguoiDung update(NguoiDung nguoiDung, Integer id) {
        Optional<NguoiDung> optional = repository.findById(id);
        return optional.map(rep -> {
            rep.setChucVu(nguoiDung.getChucVu());
            rep.setTenND(nguoiDung.getTenND());
            rep.setTenDemND(nguoiDung.getTenDemND());
            rep.setHoND(nguoiDung.getHoND());
            rep.setSdtND(nguoiDung.getSdtND());
            rep.setGioiTinhND(nguoiDung.getGioiTinhND());
            rep.setNgaySinhND(nguoiDung.getNgaySinhND());
            rep.setEmailND(nguoiDung.getEmailND());
            rep.setUseName(nguoiDung.getUseName());
            rep.setPassWord(nguoiDung.getPassWord());
            rep.setAnhND(nguoiDung.getAnhND());
            rep.setTrangThaiND(nguoiDung.getTrangThaiND());
            return repository.save(rep);
        }).orElse(null);
    }
}
