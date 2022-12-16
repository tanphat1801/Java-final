package com.example.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.ecommerce.models.User;
import com.example.ecommerce.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository users, BCryptPasswordEncoder encoder) {
        return args -> {
            users.save(new User("000000", encoder.encode("password"), "ROLE_USER"));
            users.save(new User("111111", encoder.encode("password"), "ROLE_ADMIN"));
        };
    }
}
