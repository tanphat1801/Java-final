package com.example.ecommerce.controllers;

import com.example.ecommerce.models.User;
import com.example.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public void getAllUsers() {
         List<User> users = new ArrayList<>();
         users = userService.getAllUsers();
         users.forEach(System.out::println);
    }

    @PostMapping
    public String register(@RequestBody User user) {
        /* pass JSON
            {
                "name": "A",
                "tel": "xxx",
                "gender": "nam",
                "address": "q7",
                "password": "123"
            } */
        userService.register(user);
        // replace html here
        return "users";
    }

    @PatchMapping("/{userId}")
    public String edit(@RequestBody User user, @PathVariable(name = "userId") Long id) {
        userService.updateUser(
                id,
                user.getName(),
                user.getTel(),
                user.getGender(),
                user.getAddress()
        );

        return "users";
    }

    @DeleteMapping("/{userId}")
    public String delete(@PathVariable(name = "userId") Long id) {
        userService.deleteUser(id);
        return "users";
    }
}
