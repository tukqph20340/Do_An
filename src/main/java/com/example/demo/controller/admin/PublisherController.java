package com.example.demo.controller.admin;


import com.example.demo.entity.BookJacket;
import com.example.demo.entity.Publisher;
import com.example.demo.service.BookJacketService;
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
@RequestMapping("/publisher/")
public class PublisherController {


    @Autowired
    PublisherService service;

    @GetMapping("hien-thi")
    public String getAll(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<Publisher> categoryList = service.getPage(pageNo, 5);
        model.addAttribute("list", categoryList.getContent());
        model.addAttribute("categoryPage", categoryList.getTotalPages());
        model.addAttribute("pageNumber", pageNo);
        model.addAttribute("Cate", new Publisher());
        return "admin/publisher/publisher.html";
    }

    @GetMapping("view-add")
    public String viewAll() {
        return "admin/publisher/add_publisher.html";
    }

    @PostMapping("add")
    public String add(@RequestParam("ten") String ten,
                      @RequestParam("email") String email,
                      @RequestParam("sdt") String sdt,
                      @RequestParam("diaChi") String diaChi,
                      @RequestParam("quocGia") String quocGia
                      ) {
        Publisher publisher = new Publisher();
        publisher.setFullname(ten);
        publisher.setEmail(email);
        publisher.setPhone(sdt);
        publisher.setAddress(diaChi);
        publisher.setCountry(quocGia);
        service.add(publisher);
        return "redirect:/publisher/hien-thi";

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        Publisher publisher = service.getOne(Integer.valueOf(id));
        service.delete(publisher);
        return "redirect:/publisher/hien-thi";

    }

    @GetMapping("view-update/{id}")
    public String update1(Model model,@PathVariable("id") String id) {
        Publisher publisher = service.getOne(Integer.valueOf(id));
        model.addAttribute("detail",publisher);
        return "admin/publisher/update_publisher.html";

    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") String id,@ModelAttribute Publisher publisher1) {
        Publisher publisher = service.getOne(Integer.valueOf(id));
        publisher.setFullname(publisher1.getFullname());
        publisher.setEmail(publisher1.getEmail());
        publisher.setPhone(publisher1.getPhone());
        publisher.setAddress(publisher1.getAddress());
        publisher.setCountry(publisher1.getCountry());
        service.update(publisher);
        return "redirect:/publisher/hien-thi";

    }
}
