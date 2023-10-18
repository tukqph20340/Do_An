package com.example.demo.controller.admin;


import com.example.demo.entity.BookJacket;
import com.example.demo.service.BookJacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/book-jacket/")
public class BookJaketController {


    @Autowired
    BookJacketService service;

    @GetMapping("hien-thi")
    public String getAll(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<BookJacket> categoryList = service.getPage(pageNo, 5);
        model.addAttribute("list", categoryList.getContent());
        model.addAttribute("categoryPage", categoryList.getTotalPages());
        model.addAttribute("pageNumber", pageNo);
        model.addAttribute("Cate", new BookJacket());
        return "admin/bookjacket/book_jacket.html";
    }

    @GetMapping("view-add")
    public String viewAll() {
        return "admin/bookjacket/add_book_jacket.html";
    }

    @PostMapping("add")
    public String add(@RequestParam("ten") String ten) {
        BookJacket bookJacket = new BookJacket();
        bookJacket.setNameJacket(ten);
       service.add(bookJacket);
        return "redirect:/book-jacket/hien-thi";

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        service.delete(Integer.valueOf(id));
        return "redirect:/book-jacket/hien-thi";

    }

    @GetMapping("view-update/{id}")
    public String update1(Model model,@PathVariable("id") String id) {
        BookJacket bookJacket =service.detail(Integer.valueOf(id));
        model.addAttribute("detail",bookJacket);
        return "admin/bookjacket/update_book_jacket.html";

    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") String id,@ModelAttribute BookJacket bookJacket) {
        BookJacket bookJacket1 =service.detail(Integer.valueOf(id));
        bookJacket1.setNameJacket(bookJacket.getNameJacket());
        service.update(bookJacket1);
        return "redirect:/book-jacket/hien-thi";

    }
}
