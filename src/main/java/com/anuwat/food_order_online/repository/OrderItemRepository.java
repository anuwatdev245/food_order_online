package com.anuwat.food_order_online.repository;

import com.anuwat.food_order_online.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
