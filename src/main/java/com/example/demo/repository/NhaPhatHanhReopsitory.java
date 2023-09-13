package com.example.demo.repository;

import com.example.demo.entity.NhaPhatHanh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NhaPhatHanhReopsitory extends JpaRepository<NhaPhatHanh ,Integer> {
}
