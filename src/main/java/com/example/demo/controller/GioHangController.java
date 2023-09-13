package com.example.demo.controller;


import com.example.demo.entity.GioHang;
import com.example.demo.sevice.GioHangSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/gio-hang")
public class GioHangController {
    @Autowired
    GioHangSevice sevice;
    @GetMapping("/hien-thi")
    public List<GioHang> getAll(){
        return sevice.getAll();
    }
    @GetMapping("/phan-trang")
    public List<GioHang> getAll(@RequestParam(value = "page" ,defaultValue = "0")int page, @RequestParam(value = "size",defaultValue = "4") int size){
        return sevice.phanTrang(page,size);
    }

    @PostMapping("/add")
    public GioHang add(@RequestBody GioHang gioHang){
        return sevice.add(gioHang);
    }

    @PostMapping("/update/{id}")
    public GioHang update(@RequestBody GioHang gioHang ,@PathVariable() Integer id){
        return sevice.update(gioHang,id);
    }
}
