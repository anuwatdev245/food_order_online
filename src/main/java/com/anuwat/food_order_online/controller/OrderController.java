package com.anuwat.food_order_online.controller;

import com.anuwat.food_order_online.model.Order;
import com.anuwat.food_order_online.model.User;
import com.anuwat.food_order_online.request.OrderRequest;
import com.anuwat.food_order_online.service.OrderService;
import com.anuwat.food_order_online.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    private final UserService userService;

    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest req,
                                             @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        Order order = orderService.createOrder(req, user);

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    public ResponseEntity <List<Order>> getOrderHistory(@RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        List<Order> orders = orderService.getUsersOrder(user.getId());

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
