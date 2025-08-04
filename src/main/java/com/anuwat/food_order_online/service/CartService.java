package com.anuwat.food_order_online.service;

import com.anuwat.food_order_online.model.CartItem;
import com.anuwat.food_order_online.request.addCartItemRequest;

public interface CartService {

    public CartItem addItemToCart(addCartItemRequest req, String jwt)throws Exception;

}
