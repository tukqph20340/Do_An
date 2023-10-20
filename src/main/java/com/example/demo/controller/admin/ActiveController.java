package com.example.demo.controller.admin;


import com.example.demo.entity.Is_active;
import com.example.demo.entity.Publisher;
import com.example.demo.service.Is_ActiveService;
import com.example.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/active/")
public class ActiveController {


    @Autowired
    Is_ActiveService is_active;

    @GetMapping("hien-thi")
    public String getAll(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<Is_active> categoryList = is_active.getPage(pageNo, 5);
        model.addAttribute("list", categoryList.getContent());
        model.addAttribute("categoryPage", categoryList.getTotalPages());
        model.addAttribute("pageNumber", pageNo);
        model.addAttribute("Cate", new Is_active());
        return "admin/active/active.html";
    }

    @GetMapping("view-add")
    public String viewAll() {
        return "admin/active/add_active.html";
    }

    @PostMapping("add")
    public String add(@RequestParam("ten") String ten,
                      @RequestParam("chiTiet") String email

                      ) {
        Is_active active = new Is_active();
        active.setNameActive(ten);
        active.setDetails(email);

        is_active.add(active);
        return "redirect:/active/hien-thi";

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        Is_active active = is_active.getOne(Integer.valueOf(id));
        is_active.delete(active);
        return "redirect:/active/hien-thi";

    }

    @GetMapping("view-update/{id}")
    public String update1(Model model,@PathVariable("id") String id) {
        Is_active publisher = is_active.getOne(Integer.valueOf(id));
        model.addAttribute("detail",publisher);
        return "admin/active/update_active.html";

    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") String id,@ModelAttribute Is_active is_active1) {
        Is_active is_active2 = is_active.getOne(Integer.valueOf(id));
        is_active2.setNameActive(is_active1.getNameActive());
        is_active2.setDetails(is_active1.getDetails());

        is_active.update(is_active2);
        return "redirect:/active/hien-thi";

    }
}
