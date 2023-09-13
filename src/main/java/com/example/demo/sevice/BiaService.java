package com.example.demo.service;

import com.example.demo.entity.Bia;

import java.util.List;

public interface BiaService {

    List<Bia> getAll();

    Bia save(Bia bia);

    Bia update(Bia bia);

    void delete(Integer id);
}
