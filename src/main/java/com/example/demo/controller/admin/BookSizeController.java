package com.example.demo.controller.admin;


import com.example.demo.entity.BookJacket;
import com.example.demo.entity.BookSize;
import com.example.demo.service.BookJacketService;
import com.example.demo.service.BookSizeService;
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
@RequestMapping("/book-size/")
public class BookSizeController {


    @Autowired
    BookSizeService service;

    @GetMapping("hien-thi")
    public String getAll(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<BookSize> categoryList = service.getPage(pageNo, 5);
        model.addAttribute("list", categoryList.getContent());
        model.addAttribute("categoryPage", categoryList.getTotalPages());
        model.addAttribute("pageNumber", pageNo);
        model.addAttribute("Cate", new BookSize());
        return "admin/booksize/book_size.html";
    }

    @GetMapping("view-add")
    public String viewAll() {
        return "admin/booksize/add_book_size.html";
    }

    @PostMapping("add")
    public String add(@RequestParam("ten") String ten) {
        BookSize bookSize = new BookSize();
        bookSize.setNameSize(ten);
        service.add(bookSize);
        return "redirect:/book-size/hien-thi";

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        service.delete(Integer.valueOf(id));
        return "redirect:/book-size/hien-thi";

    }

    @GetMapping("view-update/{id}")
    public String update1(Model model,@PathVariable("id") String id) {
        BookSize bookSize  =service.detail(Integer.valueOf(id));
        model.addAttribute("detail",bookSize);
        return "admin/booksize/update_book_size.html";

    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") String id,@ModelAttribute BookSize bookSize1) {
        BookSize bookSize  =service.detail(Integer.valueOf(id));
        bookSize.setNameSize(bookSize1.getNameSize());
        service.update(bookSize);
        return "redirect:/book-size/hien-thi";

    }
}
