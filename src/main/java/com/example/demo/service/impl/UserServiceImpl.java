package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository res;

    @Override
    public List<User> getAll() {
        return res.findAll();
    }

    @Override
    public Page<User> Page(Pageable pageable) {
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return res.findAll(pageable1);
    }

    @Override
    public User getOne(String id) {
        return res.findById(id).get();
    }

    @Override
    public User add(User user) {
        User add = User.builder()
                .avatar(user.getAvatar())
                .email(user.getEmail())
                .loginType(user.getLoginType())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .userName(user.getUserName())
                .build();
        return res.save(add);
    }

    @Override
    public User update(User user, String id) {
        User update = res.getReferenceById(id);
        update = User.builder()
                .id(id)
                .avatar(user.getAvatar())
                .email(user.getEmail())
                .loginType(user.getLoginType())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .userName(user.getUserName())
                .build();
        return res.save(update);
    }

    @Override
    public void delete(User author) {
        res.delete(author);
    }

    @Override
    public List<User> searchUsers(String keyword) {
        return res.searchUser(keyword);
    }
}
