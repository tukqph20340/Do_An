package com.example.demo.service.impl;

import com.example.demo.entity.ChucVu;
import com.example.demo.repository.ChucVuRepository;
import com.example.demo.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    ChucVuRepository repository;

    @Override
    public List<ChucVu> getAll() {
        return repository.findAll();
    }

    @Override
    public List<ChucVu> phanTrang(int page, int size) {
        return repository.findAll(PageRequest.of(page,size)).stream().toList();
    }

    @Override
    public ChucVu add(ChucVu chucVu) {
        return repository.save(chucVu);
    }

    public Boolean delete(Integer id){
        Optional<ChucVu> optional = repository.findById(id);
        if (optional.isPresent()){
            ChucVu chucVu = optional.get();
            repository.delete(chucVu);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public ChucVu update(ChucVu chucVu, Integer id) {
        Optional<ChucVu> optional = repository.findById(id);
        return optional.map(rep -> {
            rep.setTenCV(chucVu.getTenCV());
            return repository.save(rep);
        }).orElse(null);
    }
}
