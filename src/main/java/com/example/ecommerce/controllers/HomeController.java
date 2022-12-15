package com.example.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping(value = {"", "/"})
    public ModelAndView index(Model model) {
        ModelAndView mv = new ModelAndView("client/index");
        return mv;
    }

    @GetMapping("/product")
    public ModelAndView getProducts(Model model) {
        ModelAndView mv = new ModelAndView("client/product/index");
        return mv;
    }

    @GetMapping("/product/{productId}")
    public ModelAndView getProductDetail(Model model) {
        ModelAndView mv = new ModelAndView("client/product/detail");
        return mv;
    }

    @GetMapping("/cart")
    public ModelAndView getCart(Model model) {
        ModelAndView mv = new ModelAndView("client/cart");
        return mv;
    }
}
