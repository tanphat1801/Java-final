package com.example.ecommerce.models;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name, tel, address, gender, role, password;

    public User(String tel, String password, String role) {
        this.tel = tel;
        this.password = password;
        this.role = role;
    }
}
