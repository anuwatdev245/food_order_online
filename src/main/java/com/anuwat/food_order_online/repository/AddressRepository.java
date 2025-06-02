package com.anuwat.food_order_online.repository;

import com.anuwat.food_order_online.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
