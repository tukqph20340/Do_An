package com.example.demo.controller;

import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.SanPham;
import com.example.demo.service.KichThuocService;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/san-pham")
public class SanPhamController {


    @Autowired
    private SanPhamService sanPhamService;


    @GetMapping("/hien-thi")
    public List<SanPham> getAll() {
        return sanPhamService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody SanPham sanPham) {
        sanPhamService.save(sanPham);
        return ResponseEntity.ok(sanPham);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> add(@PathVariable("id") Integer id, @RequestBody SanPham sanPham) {
        sanPhamService.save(sanPham);
        return ResponseEntity.ok(sanPham);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        sanPhamService.delete(id);
    }

}
