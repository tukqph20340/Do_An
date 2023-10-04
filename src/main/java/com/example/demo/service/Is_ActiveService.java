package com.example.demo.service;

import com.example.demo.entity.Is_active;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface Is_ActiveService {
    List<Is_active> getAll();

    Page<Is_active> Page(Pageable pageable);

    Is_active getOne(Integer id);

    Is_active add(Is_active isActive);

    Is_active update(Is_active isActive , Integer id);

    void delete(Is_active isActive);
}
