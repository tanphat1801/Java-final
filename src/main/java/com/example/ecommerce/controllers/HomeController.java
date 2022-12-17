package com.example.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecommerce.models.CustomUserDetails;
import com.example.ecommerce.services.UserService;

@Controller
public class HomeController {
    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

//    @PreAuthorize("hasRole('ROLE_USER')")
//    @GetMapping("/user")
//    public ModelAndView user(Model model) {
//        ModelAndView mav = new ModelAndView("client/index");
//        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        mav.addObject("welcome", user.getUser().getTel());
//        return mav;
//    }

    @GetMapping(value = { "", "/" })
    public ModelAndView index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            model.addAttribute("isAnonymous", true);
        } else {
            CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
            model.addAttribute("isAnonymous", false);
            model.addAttribute("user", user.getUser());
        }

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
