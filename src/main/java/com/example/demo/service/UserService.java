package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> getAll();

    Page<User> Page(Pageable pageable);

    User getOne(String id);

    User add(User user);

    User update(User user , String id);

    void delete(User user);

    List<User> searchUsers(String keyword);
}
