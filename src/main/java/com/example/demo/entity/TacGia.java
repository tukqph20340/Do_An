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
@Table(name = "tac_gia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TacGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idTG;


    @Column(name = "ho")
    private String hoTG;

    @Column(name = "ten_dem")
    private String tenDemTG;

    @Column(name = "ten")
    private String tenTG;

    @Column(name = "dia_chi")
    private String diaChiTG;

    @Column(name = "sdt")
    private String sdtTG;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinhTG;

    @Column(name = "ngay_sinh")
    private Date ngaySinhTG;

}
