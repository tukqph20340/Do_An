package com.example.demo.controller;


import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;
import com.example.demo.service.Is_ActiveService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private Is_ActiveService isActiveService;


    @GetMapping("/hienthi")
    public String loadData(Model model) {
        return findPage(1, model);
    }

    @GetMapping("/saveForm")
    public String saveForm(Model model) {
        Cart cart = new Cart();
        model.addAttribute("cart", cart);
        model.addAttribute("listProduct", productService.getAll());
        model.addAttribute("listUser", userService.getAll());
        model.addAttribute("listIsActive", isActiveService.getAll());

        return "/cart/saveForm";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("cart") Cart cart, Model model) {
        cartService.save(cart);
        model.addAttribute("listCart", cartService.getAll());
        return "redirect:/cart/hienthi";
    }

    @GetMapping("/updateForm/{id}")
    public String updateForm(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("listProduct", productService.getAll());
        model.addAttribute("listUser", userService.getAll());
        model.addAttribute("listIsActive", isActiveService.getAll());
        model.addAttribute("cart", cartService.getById(id));

        return "/cart/updateForm";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute("cart") Cart cart, Model model) {
        Cart cart1 = cartService.getById(id);
        cart1.setId(cart.getId());
        cart1.setCount(cart.getCount());
        cart1.setProductid(cart.getProductid());
        cart1.setIsactiveid(cart.getIsactiveid());
        cart1.setUserid(cart.getUserid());
        cartService.update(cart1);
        return "redirect:/cart/hienthi";
    }


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable(value = "id") Integer id, Model model) {
        Cart cart = cartService.getById(id);
        model.addAttribute("cart", cart);
        return "/cart/detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id) {
        this.cartService.delete(id);
        return "redirect:/cart/hienthi";
    }

    @GetMapping("/page/{pageNo}")
    public String findPage(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<Cart> page = cartService.findPage(pageNo, pageSize);
        List<Cart> lists = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listCart", lists);

        return "/cart/hienthi";
    }

}
