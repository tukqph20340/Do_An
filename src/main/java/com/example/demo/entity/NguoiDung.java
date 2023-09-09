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
@Table(name = "nguoi_dung")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NguoiDung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idND;

    @ManyToOne
    @JoinColumn(name = "id_cv")
    private ChucVu chucVu;

    @Column(name = "ten")
    private String tenND;

    @Column(name = "ten_dem")
    private String tenDemND;

    @Column(name = "ho")
    private String hoND;

    @Column(name = "sdt")
    private String sdtND;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinhND;

    @Column(name = "ngay_sinh")
    private Date ngaySinhND;

    @Column(name = "email")
    private String emailND;

    @Column(name = "usename")
    private String useName;

    @Column(name = "password")
    private String passWord;

    @Column(name = "anh")
    private String anhND;

    @Column(name = "trang_thai")
    private Integer trangThaiND;
}
