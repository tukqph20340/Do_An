package com.example.demo.controller;


import com.example.demo.entity.Anh;
import com.example.demo.entity.NhaPhatHanh;
import com.example.demo.sevice.AnhSevice;
import com.example.demo.sevice.NhaPhatHanhSevice;
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
@RequestMapping("/anh")
public class AnhController {
    @Autowired
    AnhSevice sevice;
    @GetMapping("/hien-thi")
    public List<Anh> getAll(){
        return sevice.getAll();
    }
    @GetMapping("/phan-trang")
    public List<Anh> getAll(@RequestParam(value = "page" ,defaultValue = "0")int page, @RequestParam(value = "size",defaultValue = "4") int size){
        return sevice.phanTrang(page,size);
    }

    @PostMapping("/add")
    public Anh add(@RequestBody Anh anh){
        return sevice.add(anh);
    }

    @PostMapping("/update/{id}")
    public Anh update(@RequestBody Anh anh ,@PathVariable() Integer id){
        return sevice.update(anh,id);
    }
}
