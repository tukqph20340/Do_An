package com.example.demo.controller;

import com.example.demo.entity.Is_active;
import com.example.demo.service.Is_ActiveService;
import com.example.demo.service.impl.Is_ActiveServiceImpl;
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
@RequestMapping("/Isactive")
public class Is_activeController {
    @Autowired
    private Is_ActiveService pro = new Is_ActiveServiceImpl();

    @GetMapping("/view")
    public ResponseEntity view(){
        return new ResponseEntity(pro.getAll(), HttpStatus.OK);
    }
    @GetMapping("/page")
    public Page<Is_active> showPage(@RequestParam(defaultValue = "0") Integer p) {
        Pageable pageable1 = PageRequest.of(p, 5);
        return pro.Page(pageable1);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Is_active isActive) {
        return new ResponseEntity(pro.add(isActive), HttpStatus.CREATED);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Is_active> detail(@PathVariable Integer id) {
        Is_active is = pro.getOne(id);
        return ResponseEntity.ok(is);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        Is_active delete = pro.getOne(id);
        pro.delete(delete);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id,@RequestBody Is_active isActive){
        pro.update(isActive,id);
    }
}
