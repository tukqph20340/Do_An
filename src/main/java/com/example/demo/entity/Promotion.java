package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;
@Entity
@Table(name = "promotion")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idPromotiont;

    @Column(name = "coup_code")
    private String coup_code;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "discount_type")
    private Integer discountType;

    @Column(name = "discount_value")
    private Integer discountValue;

    @Column(name = "is_active")
    private Integer isActive;

    @Column(name = "is_public")
    private Integer isPublic;


    @Column(name = "maximum_discount_value")
    private Integer maximumDiscountValue;


}
