package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author/")
public class AuthorController {
    @Autowired
    AuthorService service;

    @GetMapping("hien-thi")
    public String getAll(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<Author> categoryList = service.getPage(pageNo, 5);
        model.addAttribute("list", categoryList.getContent());
        model.addAttribute("categoryPage", categoryList.getTotalPages());
        model.addAttribute("pageNumber", pageNo);
        model.addAttribute("Cate", new Author());
        return "admin/Author/product.html";
    }

    @GetMapping("view-add")
    public String viewAll() {
        return "admin/Author/add_product.html";
    }

    @PostMapping("add")
    public String add(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        service.add(author);
        return "redirect:/author/hien-thi";

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        service.delete(Integer.valueOf(id));
        return "redirect:/author/hien-thi";

    }

    @GetMapping("view-update/{id}")
    public String update1(Model model,@PathVariable("id") String id) {
        Author author =service.detail(Integer.valueOf(id));
        model.addAttribute("detail",author);
        return "admin/Author/update_product.html";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") String id,@ModelAttribute Author author) {
        Author author1 =service.detail(Integer.valueOf(id));
        author1.setFirstName(author.getFirstName());
        author1.setLastName(author.getLastName());
        service.update(author1);
        return "redirect:/author/hien-thi";
    }
}
