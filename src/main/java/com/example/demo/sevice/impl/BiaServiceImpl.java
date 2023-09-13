package com.example.demo.service.impl;

import com.example.demo.entity.Bia;
import com.example.demo.repository.BiaRepository;
import com.example.demo.service.BiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiaServiceImpl implements BiaService {

    @Autowired
    private BiaRepository biaRepository;


    @Override
    public List<Bia> getAll() {
        return biaRepository.findAll();
    }

    @Override
    public Bia save(Bia bia) {
        return biaRepository.save(bia);
    }

    @Override
    public Bia update(Bia bia) {
        return biaRepository.save(bia);
    }

    @Override
    public void delete(Integer id) {
        biaRepository.deleteById(id);
    }
}
