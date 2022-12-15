package com.example.ecommerce.repositories;

import com.example.ecommerce.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Long> {
    @Transactional
    @Modifying
    @Query("update Order set shippingMethod=(:shippingMethod), shippingFee=(:shippingFee), note=(:note), receiveDestination=(:receiveDestination), status=(:status) where id=(:id)")
    public void updateOrder(Long id, String shippingMethod, Integer shippingFee, String note, String receiveDestination, String status);

    @Transactional
    @Modifying
    @Query("update Order set status=(:status) where id=(:id)")
    public void updateOrderStatus(Long id, String status);
}
