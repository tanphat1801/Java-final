package com.example.ecommerce.models;

import com.example.ecommerce.utils.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name, address, role;
//    @Size(min = 6, max=16)
    private String password;
    @Size(min = 10, max=10)
    @Column(unique = true)
    private String tel;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<CartItem> cartItems;

    public User(String tel, String password, String role) {
        this.tel = tel;
        this.password = password;
        this.role = role;
    }
}

