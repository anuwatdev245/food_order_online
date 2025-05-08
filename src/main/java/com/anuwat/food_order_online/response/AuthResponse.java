package com.anuwat.food_order_online.response;

import com.anuwat.food_order_online.model.USER_ROLE;
import lombok.Data;

@Data
public class AuthResponse {

    private String jwt;

    private String message;

    private USER_ROLE role;

}
