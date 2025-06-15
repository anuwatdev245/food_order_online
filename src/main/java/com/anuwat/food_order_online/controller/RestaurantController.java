package com.anuwat.food_order_online.controller;

import com.anuwat.food_order_online.model.Restaurant;
import com.anuwat.food_order_online.model.User;
import com.anuwat.food_order_online.request.CreateRestaurantRequest;
import com.anuwat.food_order_online.service.RestaurantService;
import com.anuwat.food_order_online.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants/")
public class RestaurantController {

    private final RestaurantService restaurantService;

    private final UserService userService;

    public RestaurantController(RestaurantService restaurantService, UserService userService) {
        this.restaurantService = restaurantService;
        this.userService = userService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurant(@RequestHeader("Authorization") String jwt,
                                                 @RequestParam String keyword) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        List<Restaurant> restaurant = restaurantService.searchRestaurant(keyword);

        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

}
