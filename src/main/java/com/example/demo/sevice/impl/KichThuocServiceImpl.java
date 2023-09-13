package com.example.demo.service.impl;

import com.example.demo.entity.KichThuoc;
import com.example.demo.repository.KichThuocRepository;
import com.example.demo.service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KichThuocServiceImpl implements KichThuocService {

    @Autowired
    private KichThuocRepository kichThuocRepository;

    @Override
    public List<KichThuoc> getAll() {
        return kichThuocRepository.findAll();
    }

    @Override
    public KichThuoc save(KichThuoc kichThuoc) {
        return kichThuocRepository.save(kichThuoc);
    }

    @Override
    public KichThuoc update(KichThuoc kichThuoc) {
        return kichThuocRepository.save(kichThuoc);
    }

    @Override
    public void delete(Integer id) {
        kichThuocRepository.deleteById(id);
    }
}
