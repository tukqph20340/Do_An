package com.example.demo.service.impl;

import com.example.demo.entity.NhaSanXuat;
import com.example.demo.repository.NhaSanXuatRepository;
import com.example.demo.service.NhaSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaSanXuatServiceImpl implements NhaSanXuatService {
    @Autowired
    NhaSanXuatRepository repository;

    @Override
    public List<NhaSanXuat> getAll() {
        return repository.findAll();
    }

    @Override
    public List<NhaSanXuat> phanTrang(int page, int size) {
        return repository.findAll(PageRequest.of(page,size)).stream().toList();
    }

    @Override
    public NhaSanXuat add(NhaSanXuat nhaSanXuat) {
        return repository.save(nhaSanXuat);
    }

    public Boolean delete(Integer id){
        Optional<NhaSanXuat> optional = repository.findById(id);
        if (optional.isPresent()){
            NhaSanXuat nhaSanXuat = optional.get();
            repository.delete(nhaSanXuat);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public NhaSanXuat update(NhaSanXuat nhaSanXuat, Integer id) {
        Optional<NhaSanXuat> optional = repository.findById(id);
        return optional.map(rep -> {
            rep.setTenNSX(nhaSanXuat.getTenNSX());
            rep.setDiaChiNSX(nhaSanXuat.getDiaChiNSX());
            rep.setSdtNSX(nhaSanXuat.getSdtNSX());
            rep.setThanhPhoNSX(nhaSanXuat.getThanhPhoNSX());
            rep.setQuocGiaNSX(nhaSanXuat.getQuocGiaNSX());
            rep.setEmailNSX(nhaSanXuat.getEmailNSX());
            return repository.save(rep);
        }).orElse(null);
    }
}
