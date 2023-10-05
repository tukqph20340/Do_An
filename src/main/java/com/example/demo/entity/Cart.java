package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "cart")
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "count")
    private Integer count;

    @ManyToOne @JoinColumn(name = "product_id")
    private Product product_id;
//
//    @ManyToOne @JoinColumn(name = "user_id")
//    private Userr user_id;
//
//    @ManyToOne @JoinColumn(name = "is_active_id")
//    private IsActive is_active_id;


}
