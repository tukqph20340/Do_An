package com.example.demo.controller.admin;


import com.example.demo.entity.Producer;
import com.example.demo.entity.Publisher;
import com.example.demo.service.ProducerService;
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
@RequestMapping("/producer/")
public class ProducerController {


    @Autowired
    ProducerService service;

    @GetMapping("hien-thi")
    public String getAll(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<Producer> categoryList = service.getPage(pageNo, 5);
        model.addAttribute("list", categoryList.getContent());
        model.addAttribute("categoryPage", categoryList.getTotalPages());
        model.addAttribute("pageNumber", pageNo);
        model.addAttribute("Cate", new Producer());
        return "admin/producer/producer.html";
    }

    @GetMapping("view-add")
    public String viewAll() {
        return "admin/producer/add_producer.html";
    }

    @PostMapping("add")
    public String add(@RequestParam("ten") String ten,
                      @RequestParam("email") String email,
                      @RequestParam("sdt") String sdt,
                      @RequestParam("diaChi") String diaChi,
                      @RequestParam("quocGia") String quocGia
                      ) {
        Producer producer = new Producer();
        producer.setFullname(ten);
        producer.setEmail(email);
        producer.setPhone(sdt);
        producer.setAddress(diaChi);
        producer.setCountry(quocGia);
        service.add(producer);
        return "redirect:/producer/hien-thi";

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        Producer producer = service.getOne(Integer.valueOf(id));
        service.delete(producer);
        return "redirect:/producer/hien-thi";

    }

    @GetMapping("view-update/{id}")
    public String update1(Model model,@PathVariable("id") String id) {
        Producer producer = service.getOne(Integer.valueOf(id));
        model.addAttribute("detail",producer);
        return "admin/producer/update_producer.html";

    }
//
    @PostMapping("update/{id}")
    public String update(@PathVariable("id") String id,@ModelAttribute Producer producer) {
        Producer publisher1 = service.getOne(Integer.valueOf(id));
        publisher1.setFullname(producer.getFullname());
        publisher1.setEmail(producer.getEmail());
        publisher1.setPhone(producer.getPhone());
        publisher1.setAddress(producer.getAddress());
        publisher1.setCountry(producer.getCountry());
        service.update(publisher1);
        return "redirect:/producer/hien-thi";

    }
}
