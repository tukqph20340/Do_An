package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "orderritem")
public class OrderrItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "count")
    private Integer count;

    @ManyToOne @JoinColumn(name = "product_id")
    private Product product_id;

    @ManyToOne @JoinColumn(name = "order_id")
    private Orderr order_id;
}
