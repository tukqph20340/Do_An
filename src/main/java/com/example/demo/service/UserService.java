package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(String id);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(String id);
    Page<User> getAll(Pageable pageable);
    List<User> searchUsers(String keyword);
}
