package com.example.demo.controller;

import com.example.demo.entity.GioHang;
import com.example.demo.entity.GioHangChiTiet;
import com.example.demo.sevice.GioHangChiTietSevice;
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
@RestController
@RequestMapping("/gio-hang-chi-tiet")
public class GioHangChiTietController {
    @Autowired
    GioHangChiTietSevice sevice;
    @GetMapping("/hien-thi")
    public List<GioHangChiTiet> getAll(){
        return sevice.getAll();
    }
    @GetMapping("/phan-trang")
    public List<GioHangChiTiet> getAll(@RequestParam(value = "page" ,defaultValue = "0")int page, @RequestParam(value = "size",defaultValue = "4") int size){
        return sevice.phanTrang(page,size);
    }

    @PostMapping("/add")
    public GioHangChiTiet add(@RequestBody GioHangChiTiet gioHangChiTiet){
        return sevice.add(gioHangChiTiet);
    }

    @PostMapping("/update/{id}")
    public GioHangChiTiet update(@RequestBody GioHangChiTiet gioHangChiTiet ,@PathVariable() Integer id){
        return sevice.update(gioHangChiTiet,id);
    }
}
