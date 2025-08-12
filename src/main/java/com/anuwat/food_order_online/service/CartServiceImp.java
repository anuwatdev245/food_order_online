package com.anuwat.food_order_online.service;

import com.anuwat.food_order_online.model.Cart;
import com.anuwat.food_order_online.model.CartItem;
import com.anuwat.food_order_online.model.Food;
import com.anuwat.food_order_online.model.User;
import com.anuwat.food_order_online.repository.CartItemRepository;
import com.anuwat.food_order_online.repository.CartRepository;
import com.anuwat.food_order_online.repository.FoodRepository;
import com.anuwat.food_order_online.request.addCartItemRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImp implements CartService {

    private final CartRepository cartRepository;

    private final CartItemRepository cartItemRepository;

    private final UserService userService;

    private final FoodService foodService;

    public CartServiceImp(CartRepository cartRepository, CartItemRepository cartItemRepository, UserService userService, FoodService foodService) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.userService = userService;
        this.foodService = foodService;
    }

    @Override
    public CartItem addItemToCart(addCartItemRequest req, String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        Food food = foodService.findFoodById(req.getFoodId());

        Cart cart = cartRepository.findByCustomerId(user.getId());

        for (CartItem cartItem : cart.getItem()) {
            if (cartItem.getFood().equals(food)) {
                int newQuantity = cartItem.getQuantity()+req.getQuantity();
                return updateCartItemQuantity(cartItem.getId(), newQuantity);
            }
        }

        CartItem newCartItem = new CartItem();
        newCartItem.setCart(cart);
        newCartItem.setFood(food);
        newCartItem.setQuantity(req.getQuantity());
        newCartItem.setIngredients(req.getIngredients());
        newCartItem.setTotalPrice(req.getQuantity()*food.getPrice());

        CartItem savedCartItem = cartItemRepository.save(newCartItem);

        cart.getItem().add(savedCartItem);

        return savedCartItem;
    }

    @Override
    public CartItem updateCartItemQuantity(Long cartItemId, int quantity) throws Exception {

        Optional<CartItem> opt = cartItemRepository.findById(cartItemId);
        if (opt.isEmpty()) {
            throw new Exception("cart item not found");
        }
        CartItem item = opt.get();
        item.setQuantity(quantity);
        item.setTotalPrice(item.getFood().getPrice()*quantity);

        return cartItemRepository.save(item);
    }

    @Override
    public Cart removeItemFromCart(Long cartItemId, String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        Cart cart = cartRepository.findByCustomerId(user.getId());

        Optional<CartItem> opt = cartItemRepository.findById(cartItemId);
        if (opt.isEmpty()) {
            throw new Exception("cart item not found");
        }
        CartItem item = opt.get();
        cart.getItem().remove(item);

        return cartRepository.save(cart);
    }

    @Override
    public Long calculateCartTotals(Cart cart) throws Exception {

        Long total = 0L;

        for (CartItem cartItem : cart.getItem()) {
            total += cartItem.getFood().getPrice()*cartItem.getQuantity();
        }

        return total;
    }

    @Override
    public Cart findCartById(Long id) throws Exception {

        Optional<Cart> opt = cartRepository.findById(id);
        if (opt.isEmpty()) {
            throw new Exception("cart not found with id" + id);
        }

        return opt.get();
    }

    @Override
    public Cart findCartByUserId(Long userId) throws Exception {

        return cartRepository.findByCustomerId(userId);
    }

    @Override
    public Cart clearCart(Long userId) throws Exception {

        Cart cart = findCartByUserId(userId);
        cart.getItem().clear();

        return cartRepository.save(cart);
    }
}
