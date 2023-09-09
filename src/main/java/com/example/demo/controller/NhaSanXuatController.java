package com.example.demo.controller;

import com.example.demo.entity.NhaSanXuat;
import com.example.demo.service.NhaSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nha-san-xuat")
public class NhaSanXuatController {
    @Autowired
    NhaSanXuatService sevice;

    @GetMapping("/hien-thi")
    public List<NhaSanXuat> getAll(){
        return sevice.getAll();
    }

    @GetMapping("/phan-trang")
    public List<NhaSanXuat> getAll(@RequestParam(value = "page" ,defaultValue = "0")int page, @RequestParam(value = "size",defaultValue = "4") int size){
        return sevice.phanTrang(page,size);
    }

    @PostMapping("/add")
    public NhaSanXuat add(@RequestBody NhaSanXuat nhaSanXuat){
        return sevice.add(nhaSanXuat);
    }

    @PostMapping("/update/{id}")
    public NhaSanXuat update(@RequestBody NhaSanXuat nhaSanXuat ,@PathVariable() Integer id){
        return sevice.update(nhaSanXuat,id);
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
