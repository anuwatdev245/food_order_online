package com.anuwat.food_order_online.repository;

import com.anuwat.food_order_online.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String username);

}
