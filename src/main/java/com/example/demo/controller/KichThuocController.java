package com.example.demo.controller;

import com.example.demo.entity.Bia;
import com.example.demo.entity.KichThuoc;
import com.example.demo.service.BiaService;
import com.example.demo.service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kich-thuoc")
public class KichThuocController {

    @Autowired
    private KichThuocService kichThuocService;


    @GetMapping("/hien-thi")
    public List<KichThuoc> getAll() {
        return kichThuocService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody KichThuoc kichThuoc) {
        kichThuocService.save(kichThuoc);
        return ResponseEntity.ok(kichThuoc);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> add(@PathVariable("id") Integer id, @RequestBody KichThuoc kichThuoc) {
        kichThuocService.save(kichThuoc);
        return ResponseEntity.ok(kichThuoc);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        kichThuocService.delete(id);
    }


}
