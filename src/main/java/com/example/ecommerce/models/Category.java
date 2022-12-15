package com.example.ecommerce.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "categories")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Product> products;
}
