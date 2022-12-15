package com.example.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/category")
@Controller
public class CategoryController {

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
