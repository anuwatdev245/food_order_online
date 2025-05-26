package com.anuwat.food_order_online.service;

import com.anuwat.food_order_online.model.User;

public interface UserService {

    public User findUserByJwtToken(String jwt) throws Exception;

    public User findUserByEmail(String email) throws Exception;

}
