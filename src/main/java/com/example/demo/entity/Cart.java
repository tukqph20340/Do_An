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

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productid;

    @ManyToOne @JoinColumn(name = "user_id")
    private User userid;

    @ManyToOne @JoinColumn(name = "is_active_id")
    private Is_active isactiveid;

}
