package com.example.demo.controller;

import com.example.demo.entity.Producer;
import com.example.demo.service.ProducerService;
import com.example.demo.service.ProductService;
import com.example.demo.service.impl.ProducerServiceImpl;
import com.example.demo.service.impl.ProductServiceImpl;
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
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private ProducerService pro = new ProducerServiceImpl();

    @GetMapping("/view")
    public ResponseEntity hienThi() {
        return new ResponseEntity(pro.getAll(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public Page<Producer> showPage(@RequestParam(defaultValue = "0") Integer p) {
        Pageable pageable1 = PageRequest.of(p, 5);
       return pro.Page(pageable1);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Producer producer) {
        return new ResponseEntity(pro.add(producer), HttpStatus.CREATED);
    }

    @GetMapping("/details/{id}")
    public Producer detail(@PathVariable Integer id) {
        return pro.getOne(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        Producer delete = pro.getOne(id);
        pro.delete(delete);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id,@RequestBody Producer producer){
       pro.update(producer,id);
    }
}
