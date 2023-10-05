package com.example.demo.service;


import com.example.demo.entity.Orderr;

import java.util.List;
public interface OrderrService {

    List<Orderr> getAll();

    Orderr save(Orderr orderr);

    Orderr update(Orderr orderr);

    void delete(Integer id);
}
