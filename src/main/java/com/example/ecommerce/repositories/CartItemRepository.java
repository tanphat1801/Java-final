package com.example.ecommerce.repositories;

import com.example.ecommerce.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Transactional
    @Modifying
    @Query("update CartItem set quantity=(:quantity) where id=(:id)")
    public void updateCartItem(Long id, Integer quantity);
}
