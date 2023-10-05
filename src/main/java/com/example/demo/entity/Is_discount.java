package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "is_discount")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Is_discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name_sale")
    private String nameSale;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "first_date")
    private LocalDate firstDate;

    @Column(name = "last_date")
    private LocalDate lastDate;

    @Column(name = "percent_decrease")
    private Integer percentDecrease;

    @Column(name = "code_discount")
    private String codeDiscount;

    @Column(name = "describing")
    private String describing;

    @Column(name = "is_active")
    private String isActive;

}
