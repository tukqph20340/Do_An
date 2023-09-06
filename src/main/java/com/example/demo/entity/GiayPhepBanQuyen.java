package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;
@Table(name = "giay_phep_ban_quyen")
@Entity
@Data
public class GiayPhepBanQuyen {
    @EmbeddedId
    private IdGiayPhepBanQuyen id;

    @Override
    public String toString() {
        return "GiayPhepBanQuyen{" +
                "id=" + id +
                '}';
    }
}
