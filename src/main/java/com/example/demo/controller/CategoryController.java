package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService cateService;

    @GetMapping("/hienthi")
    public String loadData(Model model) {
        return findPage(1, model);
    }

    @GetMapping("/saveForm")
    public String saveForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "/category/saveForm";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("category") Category category, Model model) {
        cateService.save(category);
        model.addAttribute("listCate", cateService.getAll());
        return "redirect:/category/hienthi";
    }

    @GetMapping("/updateForm/{id}")
    public String updateForm(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("category", cateService.getById(id));
        return "/category/updateForm";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute("category") Category category, Model model) {
        Category category1 = cateService.getById(id);
        category1.setCategoryname(category.getCategoryname());
        cateService.update(category1);
        return "redirect:/category/hienthi";
    }


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable(value = "id") Integer id, Model model) {
        Category category = cateService.getById(id);
        model.addAttribute("category", category);
        return "/category/detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id) {
        this.cateService.delete(id);
        return "redirect:/category/hienthi";
    }

    @GetMapping("/page/{pageNo}")
    public String findPage(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<Category> page = cateService.findPage(pageNo, pageSize);
        List<Category> lists = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listCate", lists);

        return "/category/hienthi";
    }

}
