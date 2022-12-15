package com.example.ecommerce.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Product product;

    private Integer quantity;

}
