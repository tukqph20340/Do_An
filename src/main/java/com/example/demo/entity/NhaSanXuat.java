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
@Table(name = "nha_phat_hanh")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NhaSanXuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idNSX;

    @Column(name = "ten")
    private String tenNSX;

    @Column(name = "dia_chi")
    private String diaChiNSX;

    @Column(name = "sdt")
    private String sdtNSX;

    @Column(name = "thanh_pho")
    private String thanhPhoNSX;

    @Column(name = "quoc_gia")
    private String quocGiaNSX;

    @Column(name = "email")
    private String emailNSX;
}
