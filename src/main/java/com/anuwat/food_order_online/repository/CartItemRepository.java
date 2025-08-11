package com.anuwat.food_order_online.repository;

import com.anuwat.food_order_online.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
