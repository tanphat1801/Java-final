package com.example.ecommerce.controllers;

import com.example.ecommerce.dtos.RegisterDTO;
import com.example.ecommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String login(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/";
    }
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new RegisterDTO());
        return "register";
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") RegisterDTO registerDTO, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "register";
        }

        userService.register(registerDTO.copy());
        return "redirect:/login";
    }
    //access denied
    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }
    @GetMapping("/404")
    public String notFound(){
        return "notFound";
    }
}
