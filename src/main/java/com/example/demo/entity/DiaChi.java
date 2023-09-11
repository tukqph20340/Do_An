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
@Table(name = "dia_chi")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DiaChi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idDC;

    @ManyToOne
    @JoinColumn(name = "id_nd")
    private NguoiDung nguoiDung;

    @Column(name = "ten")
    private String tenDC;

    @Column(name = "sdt")
    private String sdtDC;

    @Column(name = "dia_chi")
    private String diaChiDC;

    @Column(name = "thanh_pho")
    private String thanhPhoDC;

    @Column(name = "quoc_gia")
    private String quocGiaDC;
}
