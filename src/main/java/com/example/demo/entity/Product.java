package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "description_", length = 1111)
    private String description;

    @Column(name = "is_active")
    private Integer isActive;

    @Column(name = "is_selling")
    private Integer isSelling;

    @Column(name = "price")
    private Integer price;

    @Column(name = "product_name", length = 1111)
    private String productName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "sold")
    private Integer sold;

//    @ManyToOne
//    @JoinColumn(name = "category_id", referencedColumnName = "id")
//    private Category category;
//
//    @ManyToOne
//    @JoinColumn(name = "author_id", referencedColumnName = "id")
//    private Author author;
//
//    @ManyToOne
//    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
//    private Publisher publisher;
//
//    @ManyToOne
//    @JoinColumn(name = "producer_id", referencedColumnName = "id")
//    private Producer producer;
//
//    @ManyToOne
//    @JoinColumn(name = "is_discount_id", referencedColumnName = "id")
//    private IsDiscount isDiscount;
//
//    @ManyToOne
//    @JoinColumn(name = "book_jacket_id", referencedColumnName = "id")
//    private BookJacket bookJacket;
//
//    @ManyToOne
//    @JoinColumn(name = "book_size_id", referencedColumnName = "id")
//    private BookSize bookSize;
}
