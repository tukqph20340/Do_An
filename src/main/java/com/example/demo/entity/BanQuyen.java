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
@Table(name = "ban_quyen")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BanQuyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_sp")
    private SanPham sanPham;


    @Column(name = "ngay_dang_ky")
    private Date ngayDangKy;

    @Column(name = "ngay_cap")
    private Date ngayCap;


    @Column(name = "ngay_het_han")
    private Date ngayHetHan;


    @Column(name = "trang_thai")
    private Integer trangThai;
}
