package com.example.demo.controller;

import com.example.demo.entity.Product_image;
import com.example.demo.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product_image/")
public class ProductImgController {
    @Autowired
    ProductImageService service;

    @GetMapping("hien-thi")
    public String getAll(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<Product_image> categoryList = service.getPage(pageNo, 5);
        model.addAttribute("list", categoryList.getContent());
        model.addAttribute("categoryPage", categoryList.getTotalPages());
        model.addAttribute("pageNumber", pageNo);
        model.addAttribute("Cate", new Product_image());
        return "admin/Product_image/product_image.html";
    }

    @GetMapping("view-add")
    public String viewAll() {
        return "admin/Product_image/add_product_image.html";
    }

    @PostMapping("add")
    public String add(@RequestParam("imageUrl") String imageUrl){
        Product_image product_image = new Product_image();
        product_image.setImageUrl(imageUrl);
        service.add(product_image);
        return "redirect:/product_image/hien-thi";

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        service.delete(Integer.valueOf(id));
        return "redirect:/product_image/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String update1(Model model,@PathVariable("id") String id) {
        Product_image product_image =service.detail(Integer.valueOf(id));
        model.addAttribute("detail",product_image);
        return "admin/Product_image/update_product_image.html";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") String id,@ModelAttribute Product_image product_image) {
        Product_image product_image1 =service.detail(Integer.valueOf(id));
        product_image1.setImageUrl(product_image.getImageUrl());
        service.update(product_image1);
        return "redirect:/product_image/hien-thi";
    }
}
