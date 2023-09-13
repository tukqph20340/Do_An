package com.example.demo.controller;

import com.example.demo.entity.BanQuyen;
import com.example.demo.service.BanQuyenSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banquyen")
public class BanQuyenController {
    @Autowired
    BanQuyenSerivce ser;

    @GetMapping("/getAll")
    public List<BanQuyen> getAll(){
        return ser.getAll();
    }
    @GetMapping("/page")
    public Page<BanQuyen> page(@RequestParam(value ="p", defaultValue = "0") Integer p ){
        Pageable pageable = PageRequest.of(p,5);
        return ser.phanTrang(pageable);
    }
    @PostMapping("/add")
    public BanQuyen Add(@RequestBody BanQuyen banQuyen){
        return ser.add(banQuyen);
    }
    @DeleteMapping("/delete/{id}")
    public void Delete(@PathVariable("id") Integer id){
          ser.delete(id);
    }
    @PutMapping("/update/{id}")
    public BanQuyen update(@PathVariable("id") Integer id, @RequestBody BanQuyen banQuyen){
        return ser.update(banQuyen,id);
    }
}
