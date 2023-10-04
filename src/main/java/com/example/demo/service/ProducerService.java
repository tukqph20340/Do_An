package com.example.demo.service;

import com.example.demo.entity.Producer;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProducerService {
    List<Producer> getAll();

    Page<Producer> Page(Pageable pageable);

    Producer getOne(Integer id);

    Producer add(Producer producer);

    Producer update(Producer producer , Integer id);

    void delete(Producer producer);
}
