package com.example.demo.controller;

import com.example.demo.entity.Is_discount;
import com.example.demo.service.Is_discountService;
import com.example.demo.service.impl.Is_discountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Isdiscount")
public class Is_discountController {
    @Autowired
    private Is_discountService pro = new Is_discountServiceImpl();

    @GetMapping("/view")
    public ResponseEntity hienThi() {
        return new ResponseEntity(pro.getAll(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public Page<Is_discount> showPage(@RequestParam(defaultValue = "0") Integer p) {
        Pageable pageable1 = PageRequest.of(p, 5);
        return pro.Page(pageable1);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Is_discount isDiscount) {
        return new ResponseEntity(pro.add(isDiscount), HttpStatus.CREATED);
    }

    @GetMapping("/details/{id}")
    public Is_discount detail(@PathVariable Integer id) {
        return pro.getOne(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        Is_discount delete = pro.getOne(id);
        pro.delete(delete);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id,@RequestBody Is_discount isDiscount){
        pro.update(isDiscount,id);
    }

}
