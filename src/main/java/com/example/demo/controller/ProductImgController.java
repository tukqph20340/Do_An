package com.example.demo.controller;

import com.example.demo.entity.Product_image;
import com.example.demo.service.ProductImageService;
import com.example.demo.service.impl.ProductImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ProductImage")
public class ProductImgController {
    @Autowired
    private ProductImageService pro = new ProductImageServiceImpl();

    @GetMapping("/view")
    public ResponseEntity view(){
        return new ResponseEntity(pro.getAll(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public Page<Product_image> showPage(@RequestParam(defaultValue = "0") Integer p) {
        Pageable pageable1 = PageRequest.of(p, 5);
        return pro.Page(pageable1);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Product_image product_image) {
        return new ResponseEntity(pro.add(product_image), HttpStatus.CREATED);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Product_image> detail(@PathVariable Integer id) {
        Product_image is = pro.getOne(id);
        return ResponseEntity.ok(is);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        Product_image delete = pro.getOne(id);
        pro.delete(delete);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id,@RequestBody Product_image product_image){
        pro.update(product_image, id);
    }

    @GetMapping("/search")
    public List<Product_image> search(@RequestParam String keyword) {
        return pro.searchProductImages(keyword);
    }
}
