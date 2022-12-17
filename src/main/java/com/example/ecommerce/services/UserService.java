package com.example.ecommerce.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.ecommerce.utils.Gender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ecommerce.models.CustomUserDetails;
import com.example.ecommerce.models.User;
import com.example.ecommerce.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public void register(User user) {
        if (user.getRole() == null || Objects.equals(user.getRole(), "")) {
            user.setRole("ROLE_USER");
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }
    public void updateUser(Long id, String name, String tel, Gender gender, String address) {
        System.out.println(id + " " + name + " " + tel + " " + gender + " " + address);
        userRepository.updateUser(id, name, tel, gender, address);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String tel) {
        // Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findByTel(tel);

        if (user==null) {
            throw new UsernameNotFoundException(tel);
        }
        return new CustomUserDetails(user);
    }
}
