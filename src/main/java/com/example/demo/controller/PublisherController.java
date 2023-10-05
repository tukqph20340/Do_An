package com.example.demo.controller;

import com.example.demo.entity.Publisher;
import com.example.demo.service.PublisherService;
import com.example.demo.service.impl.PublisherServiceImpl;
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
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private PublisherService pro = new PublisherServiceImpl();

    @GetMapping("/view")
    public ResponseEntity view(){
        return new ResponseEntity(pro.getAll(), HttpStatus.OK);
    }
    @GetMapping("/page")
    public Page<Publisher> showPage(@RequestParam(defaultValue = "0") Integer p) {
        Pageable pageable1 = PageRequest.of(p, 5);
        return pro.Page(pageable1);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Publisher publisher) {
        return new ResponseEntity(pro.add(publisher), HttpStatus.CREATED);
    }

    @GetMapping("/details/{id}")
    public Publisher detail(@PathVariable Integer id) {
        return pro.getOne(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        Publisher delete = pro.getOne(id);
        pro.delete(delete);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id,@RequestBody Publisher publisher){
        pro.update(publisher,id);
    }
}
