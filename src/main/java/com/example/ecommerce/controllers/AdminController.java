package com.example.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @GetMapping(value = { "", "/" })
    public ModelAndView getProducts(Model model) {
        ModelAndView mv = new ModelAndView("admin/product/index");
        return mv;
    }

    @GetMapping("/category")
    public ModelAndView getCategories(Model model) {
        ModelAndView mv = new ModelAndView("admin/category/index");
        return mv;
    }
}
