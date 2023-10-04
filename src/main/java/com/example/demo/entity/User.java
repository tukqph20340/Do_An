package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", length = 255, nullable = false)
    private String id;

    @Column(name = "avatar", length = 1111)
    private String avatar;

    @Column(name = "email", length = 1111)
    private String email;

    @Column(name = "login_type", length = 1111)
    private String loginType;

    @Column(name = "password", length = 1111)
    private String password;

    @Column(name = "phone_number", length = 1111)
    private String phoneNumber;

    @Column(name = "role", length = 1111)
    private String role;

    @Column(name = "user_name", length = 1111)
    private String userName;
}
