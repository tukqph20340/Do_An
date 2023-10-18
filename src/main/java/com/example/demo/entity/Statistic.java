package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
@Entity
@Table(name = "statistic")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idStatistic;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "profit")
    private String profit;

    @Column(name = "quantity")
    private Integer quantity;


//    @Column(name = "sales")
//    private String sales;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orderr orderr;
}
