package com.example.demo.controller;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/khuyen-mai")
public class KhuyenMaiController {

    @Autowired
    private KhuyenMaiService khuyenMaiService;


    @GetMapping("/hien-thi")
    public List<KhuyenMai> getAll() {
        return khuyenMaiService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody KhuyenMai khuyenMai) {
        khuyenMaiService.save(khuyenMai);
        return ResponseEntity.ok(khuyenMai);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> add(@PathVariable("id") Integer id, @RequestBody KhuyenMai khuyenMai) {
        khuyenMaiService.save(khuyenMai);
        return ResponseEntity.ok(khuyenMai);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        khuyenMaiService.delete(id);
    }


}
