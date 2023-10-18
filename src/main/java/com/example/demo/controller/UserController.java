package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService pro = new UserServiceImpl();

    @GetMapping("/view")
    public ResponseEntity view(){
        return new ResponseEntity(pro.getAll(), HttpStatus.OK);
    }


    @GetMapping("/page")
    public Page<User> showPage(@RequestParam(defaultValue = "0") Integer p) {
        Pageable pageable1 = PageRequest.of(p, 5);
        return pro.Page(pageable1);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody User user) {
        return new ResponseEntity(pro.add(user), HttpStatus.CREATED);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<User> detail(@PathVariable String id) {
        User is = pro.getOne(id);
        return ResponseEntity.ok(is);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        User delete = pro.getOne(id);
        pro.delete(delete);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable String id,@RequestBody User user){
        pro.update(user, id);
    }

    @GetMapping("/search")
    public List<User> searchUserrs(@RequestParam String keyword) {
        return pro.searchUsers(keyword);
    }
}
