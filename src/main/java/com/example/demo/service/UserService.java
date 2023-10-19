package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import java.util.List;

public interface UserService {
    List<User> getAll();

    Page<User> getPage(Integer pageNo, Integer size);

    User detail(String id) ;

    void delete(String id) ;

    User add(User user);

    User update(User user);
}
