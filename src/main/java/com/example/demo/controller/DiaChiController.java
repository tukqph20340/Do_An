package com.example.demo.controller;

import com.example.demo.entity.DiaChi;
import com.example.demo.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dia-chi")
public class DiaChiController {
    @Autowired
    DiaChiService sevice;

    @GetMapping("/hien-thi")
    public List<DiaChi> getAll(){
        return sevice.getAll();
    }

    @GetMapping("/phan-trang")
    public List<DiaChi> getAll(@RequestParam(value = "page" ,defaultValue = "0")int page, @RequestParam(value = "size",defaultValue = "4") int size){
        return sevice.phanTrang(page,size);
    }

    @PostMapping("/add")
    public DiaChi add(@RequestBody DiaChi diaChi){
        return sevice.add(diaChi);
    }

    @PostMapping("/update/{id}")
    public DiaChi update(@RequestBody DiaChi diaChi ,@PathVariable() Integer id){
        return sevice.update(diaChi,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        if (sevice.delete(id)){
            return ResponseEntity.ok("Xoa thanh cong");
        }else {
            return ResponseEntity.ok("Xoa that bai");
        }
    }
}
