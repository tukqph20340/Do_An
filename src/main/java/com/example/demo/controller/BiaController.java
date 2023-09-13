package com.example.demo.controller;

import com.example.demo.entity.Bia;
import com.example.demo.entity.KhuyenMai;
import com.example.demo.service.BiaService;
import com.example.demo.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bia")
public class BiaController {

    @Autowired
    private BiaService biaService;


    @GetMapping("/hien-thi")
    public List<Bia> getAll() {
        return biaService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Bia bia) {
        biaService.save(bia);
        return ResponseEntity.ok(bia);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> add(@PathVariable("id") Integer id, @RequestBody Bia bia) {
        biaService.save(bia);
        return ResponseEntity.ok(bia);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        biaService.delete(id);
    }



}
