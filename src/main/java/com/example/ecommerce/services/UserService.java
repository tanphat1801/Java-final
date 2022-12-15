package com.example.ecommerce.services;

import com.example.ecommerce.models.User;
import com.example.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void register(User user) {
        if (user.getRole() == null) {
            user.setRole("user");
        }

        userRepository.save(user);
    }
    public void updateUser(Long id, String name, String tel, String gender, String address) {
        System.out.println(id);
        userRepository.updateUser(id, name, tel, gender, address);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
