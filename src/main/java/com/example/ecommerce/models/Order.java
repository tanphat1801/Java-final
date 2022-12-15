package com.example.ecommerce.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<OrderItem> orderItems;
    private String shippingMethod, note, receiveDestination, status;
    private Integer shippingFee;

}
