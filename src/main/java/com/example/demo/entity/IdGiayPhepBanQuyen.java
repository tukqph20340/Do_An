package com.example.demo.entity;

import jakarta.persistence.Embeddable;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;


import java.io.Serializable;
@Embeddable
@Data

public class IdGiayPhepBanQuyen implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_giay_phep")
    private GiayPhep giayPhep;

    @ManyToOne
    @JoinColumn(name = "id_ban_quyen")
    private BanQuyen banQuyen;
}
