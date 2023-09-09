package com.example.demo.controller;

import com.example.demo.entity.ChucVu;
import com.example.demo.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chuc-vu")
public class ChucVuController {
    @Autowired
    ChucVuService sevice;

    @GetMapping("/hien-thi")
    public List<ChucVu> getAll(){
        return sevice.getAll();
    }

    @GetMapping("/phan-trang")
    public List<ChucVu> getAll(@RequestParam(value = "page" ,defaultValue = "0")int page, @RequestParam(value = "size",defaultValue = "4") int size){
        return sevice.phanTrang(page,size);
    }

    @PostMapping("/add")
    public ChucVu add(@RequestBody ChucVu chucVu){
        return sevice.add(chucVu);
    }

    @PostMapping("/update/{id}")
    public ChucVu update(@RequestBody ChucVu chucVu ,@PathVariable() Integer id){
        return sevice.update(chucVu,id);
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
