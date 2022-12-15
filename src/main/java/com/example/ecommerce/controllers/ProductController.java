package com.example.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/admin/product")
@Controller
public class ProductController {
    @PostMapping("/create")
    public void create(Model model) {

        return;
    }

    @PostMapping("/update")
    public void update(Model model) {

        return;
    }

    @PostMapping("/delete")
    public void delete(Model model) {

        return;
    }
}
