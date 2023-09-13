package com.example.demo.controller;

import com.example.demo.entity.HoaDon;
import com.example.demo.sevice.HoaDonSevice;
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
@RequestMapping("/hoa-don")
public class HoaDonController {
    @Autowired
    HoaDonSevice sevice;
    @GetMapping("/hien-thi")
    public List<HoaDon> getAll(){
        return sevice.getAll();
    }
    @GetMapping("/phan-trang")
    public List<HoaDon> getAll(@RequestParam(value = "page" ,defaultValue = "0")int page, @RequestParam(value = "size",defaultValue = "4") int size){
        return sevice.phanTrang(page,size);
    }

    @PostMapping("/add")
    public HoaDon add(@RequestBody HoaDon hoaDon){
        return sevice.add(hoaDon);
    }

    @PostMapping("/update/{id}")
    public HoaDon update(@RequestBody HoaDon hoaDon ,@PathVariable() Integer id){
        return sevice.update(hoaDon,id);
    }
}
