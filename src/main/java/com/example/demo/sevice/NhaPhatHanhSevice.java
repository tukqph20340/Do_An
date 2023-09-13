package com.example.demo.sevice;

import com.example.demo.entity.NhaPhatHanh;

import java.util.List;
public interface NhaPhatHanhSevice {
    List<NhaPhatHanh> getAll();
    List<NhaPhatHanh> phanTrang(int page,int size);
    NhaPhatHanh delete(Integer id);
    NhaPhatHanh add(NhaPhatHanh nhaPhatHanh);
    NhaPhatHanh update(NhaPhatHanh nhaPhatHanh,Integer id);
}
