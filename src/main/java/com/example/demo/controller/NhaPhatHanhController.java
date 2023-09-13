package com.example.demo.controller;


import com.example.demo.entity.HoaDon;
import com.example.demo.entity.NhaPhatHanh;
import com.example.demo.sevice.HoaDonSevice;
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
@RequestMapping("/nha-phat-hanh")
public class NhaPhatHanhController {
    @Autowired
    NhaPhatHanhSevice sevice;
    @GetMapping("/hien-thi")
    public List<NhaPhatHanh> getAll(){
        return sevice.getAll();
    }
    @GetMapping("/phan-trang")
    public List<NhaPhatHanh> getAll(@RequestParam(value = "page" ,defaultValue = "0")int page, @RequestParam(value = "size",defaultValue = "4") int size){
        return sevice.phanTrang(page,size);
    }

    @PostMapping("/add")
    public NhaPhatHanh add(@RequestBody NhaPhatHanh nhaPhatHanhh){
        return sevice.add(nhaPhatHanhh);
    }

    @PostMapping("/update/{id}")
    public NhaPhatHanh update(@RequestBody NhaPhatHanh nhaPhatHanhh ,@PathVariable() Integer id){
        return sevice.update(nhaPhatHanhh,id);
    }
}
