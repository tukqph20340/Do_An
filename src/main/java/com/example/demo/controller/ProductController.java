package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@Controller
@RequestMapping("/product/")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("hien-thi")
    public String getAll(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<Product> categoryList = service.getPage(pageNo, 5);
        model.addAttribute("list", categoryList.getContent());
        model.addAttribute("categoryPage", categoryList.getTotalPages());
        model.addAttribute("pageNumber", pageNo);
        model.addAttribute("Cate", new Product());
        return "admin/Product/product.html";
    }

    @GetMapping("view-add")
    public String viewAll() {
        return "admin/Product/add_product.html";
    }

    @PostMapping("add")
    public String add(@RequestParam("createdAt") Date createdAt,
                      @RequestParam("description") String description,
                      @RequestParam("isActive") Integer isActive,
                      @RequestParam("isSelling") Integer isSelling,
                      @RequestParam("price") Integer price,
                      @RequestParam("productName") String productName,
                      @RequestParam("quantity") Integer quantity,
                      @RequestParam("sold") Integer sold){
        Product product = new Product();
        product.setCreatedAt(createdAt);
        product.setDescription(description);
        product.setIsActive(isActive);
        product.setIsSelling(isSelling);
        product.setPrice(price);
        product.setProductName(productName);
        product.setQuantity(quantity);
        product.setSold(sold);
        service.add(product);
        return "redirect:/product/hien-thi";

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        service.delete(Integer.valueOf(id));
        return "redirect:/product/hien-thi";

    }

    @GetMapping("view-update/{id}")
    public String update1(Model model,@PathVariable("id") String id) {
        Product product =service.detail(Integer.valueOf(id));
        model.addAttribute("detail",product);
        return "admin/Product/update_product.html";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") String id,@ModelAttribute Product product) {
        Product product1 =service.detail(Integer.valueOf(id));
        product1.setCreatedAt(product.getCreatedAt());
        product1.setDescription(product.getDescription());
        product1.setIsActive(product.getIsActive());
        product1.setIsSelling(product.getIsSelling());
        product1.setPrice(product.getPrice());
        product1.setProductName(product.getProductName());
        product1.setQuantity(product.getQuantity());
        product1.setSold(product.getSold());
        service.update(product1);
        return "redirect:/product/hien-thi";
    }
}
