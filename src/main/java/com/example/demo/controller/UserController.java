package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("hien-thi")
    public String getAll(Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Page<User> categoryList = service.getPage(pageNo, 5);
        model.addAttribute("list", categoryList.getContent());
        model.addAttribute("categoryPage", categoryList.getTotalPages());
        model.addAttribute("pageNumber", pageNo);
        model.addAttribute("Cate", new User());
        return "admin/User/user.html";
    }

    @GetMapping("view-add")
    public String viewAll() {
        return "admin/User/add_user.html";
    }

    @PostMapping("add")
    public String add(@RequestParam("avatar") String avatar,
                      @RequestParam("email") String email,
                      @RequestParam("loginType") String loginType,
                      @RequestParam("password") String password,
                      @RequestParam("phoneNumber") String phoneNumber,
                      @RequestParam("role") String role,
                      @RequestParam("userName") String userName) {
        User user = new User();
        user.setAvatar(avatar);
        user.setEmail(email);
        user.setLoginType(loginType);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setRole(role);
        user.setUserName(userName);
        service.add(user);
        return "redirect:/user/hien-thi";

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        service.delete(String.valueOf(Integer.valueOf(id)));
        return "redirect:/user/hien-thi";

    }

    @GetMapping("view-update/{id}")
    public String update1(Model model,@PathVariable("id") String id) {
        User user = service.detail(String.valueOf(Integer.valueOf(id)));
        model.addAttribute("detail",user);
        return "admin/User/update_user.html";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") String id,@ModelAttribute User user) {
        User user1 =service.detail(String.valueOf(Integer.valueOf(id)));
        user1.setAvatar(user.getAvatar());
        user1.setEmail(user.getEmail());
        user1.setLoginType(user.getLoginType());
        user1.setPassword(user.getPassword());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setRole(user.getRole());
        user1.setUserName(user.getUserName());
        service.update(user1);
        return "redirect:/user/hien-thi";
    }
}
