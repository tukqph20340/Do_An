package com.example.demo.repository;


import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.userName LIKE %:keyword% OR u.role LIKE %:keyword% OR u.phoneNumber LIKE %:keyword% OR u.password LIKE %:keyword%" +
            "OR u.loginType LIKE %:keyword% OR u.email LIKE %:keyword% OR u.avatar LIKE %:keyword%")
    List<User> searchUser(@Param("keyword") String keyword);
}
