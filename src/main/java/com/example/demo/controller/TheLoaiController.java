package com.example.demo.controller;


import com.example.demo.entity.TacGia;
import com.example.demo.entity.TheLoai;
import com.example.demo.sevice.TacGiaSevice;
import com.example.demo.sevice.TheLoaiSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/the-loai")
public class TheLoaiController {
    @Autowired
    TheLoaiSevice sevice;
    @GetMapping("/hien-thi")
    public List<TheLoai> getAll(){
        return sevice.getAll();
    }
    @GetMapping("/phan-trang")
    public List<TheLoai> getAll(@RequestParam(value = "page" ,defaultValue = "0")int page, @RequestParam(value = "size",defaultValue = "4") int size){
        return sevice.phanTrang(page,size);
    }

    @PostMapping("/add")
    public TheLoai add(@RequestBody TheLoai theLoai){
        return sevice.add(theLoai);
    }

    @PostMapping("/update/{id}")
    public TheLoai update(@RequestBody TheLoai theLoai ,@PathVariable() Integer id){
        return sevice.update(theLoai,id);
    }
}
