package com.anuwat.food_order_online.service;

import com.anuwat.food_order_online.model.Cart;
import com.anuwat.food_order_online.model.CartItem;
import com.anuwat.food_order_online.request.addCartItemRequest;

public interface CartService {

    public CartItem addItemToCart(addCartItemRequest req, String jwt) throws Exception;

    public CartItem updateCartItemQuantity(Long cartItemId, int quantity) throws Exception;

    public Cart removeItemFromCart(Long cartItemId, String jwt) throws Exception;

    public Long calculateCartTotals(Cart cart) throws Exception;

    public Cart findCartById(Long id) throws Exception;

    public Cart findCartByUserId(Long userId) throws Exception;

    public Cart clearCart(Long userId) throws Exception;

}
