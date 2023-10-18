package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;
import com.example.demo.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Author")
public class AuthorController {
    @Autowired
    private AuthorService pro = new AuthorServiceImpl();

    @GetMapping("/view")
    public ResponseEntity view(){
        return new ResponseEntity(pro.getAll(), HttpStatus.OK);
    }
    @GetMapping("/page")
    public Page<Author> showPage(@RequestParam(defaultValue = "0") Integer p) {
        Pageable pageable1 = PageRequest.of(p, 5);
        return pro.Page(pageable1);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Author author) {
        return new ResponseEntity(pro.add(author), HttpStatus.CREATED);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Author> detail(@PathVariable Integer id) {
        Author is = pro.getOne(id);
        return ResponseEntity.ok(is);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        Author delete = pro.getOne(id);
        pro.delete(delete);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id,@RequestBody Author author){
        pro.update(author, id);
    }

    @GetMapping("/search")
    public List<Author> searchAuthors(@RequestParam String keyword) {
        return pro.searchAuthors(keyword);
    }
}
