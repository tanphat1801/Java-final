package com.example.ecommerce.controllers;

import com.example.ecommerce.dtos.UserProfileDTO;
import com.example.ecommerce.models.CustomUserDetails;
import com.example.ecommerce.models.User;
import com.example.ecommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping
//    public ModelAndView getAllUsers(Model model) {
//        List<User> users = new ArrayList<>();
//        users = userService.getAllUsers();
//        users.forEach(System.out::println);
//        ModelAndView mv = new ModelAndView("admin/user/index");
//        return mv;
//    }
//
//    @PostMapping
//    public String register(@RequestBody User user) {
//        /*
//         * pass JSON
//         * {
//         * "name": "A",
//         * "tel": "xxx",
//         * "gender": "nam",
//         * "address": "q7",
//         * "password": "123"
//         * }
//         */
//        userService.register(user);
//        // replace html here
//        return "users";
//    }
//
//    @PatchMapping("/{userId}")
//    public String edit(@RequestBody User user, @PathVariable(name = "userId") Long id) {
//        userService.updateUser(
//                id,
//                user.getName(),
//                user.getTel(),
//                user.getGender(),
//                user.getAddress());
//
//        return "users";
//    }
//
//    @DeleteMapping("/{userId}")
//    public String delete(@PathVariable(name = "userId") Long id) {
//        userService.deleteUser(id);
//        return "users";
//    }
    @GetMapping("/profile")
    public String getUserProfile(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails) authentication.getPrincipal();

        User user = userService.getUser(customUser.getUser().getId());
        if (user == null) {
            SecurityContextHolder.getContext().setAuthentication(null);
            return "redirect:/login";
        }

        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/editProfile")
    public String editProfile(@Valid @ModelAttribute("user")UserProfileDTO userProfileDTO, BindingResult result, Model model) {
        userService.updateUser(
                userProfileDTO.getId(),
                userProfileDTO.getName(),
                userProfileDTO.getTel(),
                userProfileDTO.getGender(),
                userProfileDTO.getAddress()
        );
        return "redirect:/user/profile";
    }
}
