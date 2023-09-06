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

@Entity
@Table(name = "nha_san_xuat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NhaPhatHanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idNPH;

    @Column(name = "ten")
    private String tenNPH;


    @Column(name = "dia_chi")
    private String diaChiNPH;

    @Column(name = "sdt")
    private String sdtNPH;

    @Column(name = "thanh_pho")
    private String thanhPhoNPH;

    @Column(name = "quoc_gia")
    private String quocGiaNPH;

    @Column(name = "email")
    private String emailNPH;

}
