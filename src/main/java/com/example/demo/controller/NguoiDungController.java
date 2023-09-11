package com.example.demo.controller;

import com.example.demo.entity.NguoiDung;
import com.example.demo.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nguoi-dung")
public class NguoiDungController {

    @Autowired
    NguoiDungService sevice;

    @GetMapping("/hien-thi")
    public List<NguoiDung> getAll(){
        return sevice.getAll();
    }

    @GetMapping("/phan-trang")
    public List<NguoiDung> getAll(@RequestParam(value = "page" ,defaultValue = "0")int page, @RequestParam(value = "size",defaultValue = "4") int size){
        return sevice.phanTrang(page,size);
    }

    @PostMapping("/add")
    public NguoiDung add(@RequestBody NguoiDung nguoiDung){
        return sevice.add(nguoiDung);
    }

    @PostMapping("/update/{id}")
    public NguoiDung update(@RequestBody NguoiDung nguoiDung ,@PathVariable() Integer id){
        return sevice.update(nguoiDung,id);
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
