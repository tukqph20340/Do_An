package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "orderr")
public class Orderr {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "booking_date")
    private Date booking_date;

    @Column(name = "country")
    private String country;

    @Column(name = "email")
    private String email;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "note")
    private String note;

    @Column(name = "payment_method")
    private String payment_method;

    @Column(name = "phone")
    private String phone;

    @Column(name = "total")
    private Integer total;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne @JoinColumn(name = "is_active_id")
    private Is_active is_active_id;



}
