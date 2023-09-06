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

import java.sql.Date;
@Entity
@Table(name = "giay_phep")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GiayPhep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "so_giay_phep")
    private Integer soGiayPhep;


    @Column(name = "ngay_cap")
    private Date ngayCap;


    @Column(name = "ngay_het_han")
    private Date ngayHetHan;


    @Column(name = "nguoi_cap")
    private String nguoiCap;

    @Column(name = "trang_thai")
    private Integer trangThai;


}
