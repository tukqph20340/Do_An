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
@Entity
@Table(name = "san_pham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_anh")
    private Anh anh;

    @ManyToOne
    @JoinColumn(name = "id_nha_san_xuat")
    private NhaSanXuat nhaSanXuat;

    @ManyToOne
    @JoinColumn(name = "id_tac_gia")
    private TacGia tacGia;

    @ManyToOne
    @JoinColumn(name = "id_the_loai")
    private TheLoai theLoai;

    @ManyToOne
    @JoinColumn(name = "id_nha_phat_hanh")
    private NhaPhatHanh nhaPhatHanh;

    @ManyToOne
    @JoinColumn(name = "id_khuyen_mai")
    private KhuyenMai khuyenMai;

    @ManyToOne
    @JoinColumn(name = "id_bia")
    private Bia bia;

    @ManyToOne
    @JoinColumn(name = "id_kich_thuoc")
    private KichThuoc kichThuoc;

    @Column(name = "ten")
    private String ten;


    @Column(name = "so_trang")
    private Integer soTrang;


    @Column(name = "so_luong")
    private Integer soLuong;



    @Column(name = "gia_nhap")
    private Integer giaNhap;


    @Column(name = "gia_ban")
    private Integer giaBan;


    @Column(name = "mo_ta")
    private String moTa;



    @Column(name = "trang_thai")
    private Integer trangThai;



    @Column(name = "gia_khuyen_mai")
    private Integer giaKhuyenMai;




}
