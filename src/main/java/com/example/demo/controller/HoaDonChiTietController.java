package com.example.demo.controller;

import com.example.demo.entity.GioHangChiTiet;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.sevice.GioHangChiTietSevice;
import com.example.demo.sevice.HoaDonChiTietSevice;
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
@RequestMapping("/hoa-don-chi-tiet")
public class HoaDonChiTietController {
    @Autowired
    HoaDonChiTietSevice sevice;
    @GetMapping("/hien-thi")
    public List<HoaDonChiTiet> getAll(){
        return sevice.getAll();
    }
    @GetMapping("/phan-trang")
    public List<HoaDonChiTiet> getAll(@RequestParam(value = "page" ,defaultValue = "0")int page, @RequestParam(value = "size",defaultValue = "4") int size){
        return sevice.phanTrang(page,size);
    }

    @PostMapping("/add")
    public HoaDonChiTiet add(@RequestBody HoaDonChiTiet hoaDonChiTiet){
        return sevice.add(hoaDonChiTiet);
    }

    @PostMapping("/update/{id}")
    public HoaDonChiTiet update(@RequestBody HoaDonChiTiet hoaDonChiTiet ,@PathVariable() Integer id){
        return sevice.update(hoaDonChiTiet,id);
    }
}
