package com.anuwat.food_order_online.controller;

import com.anuwat.food_order_online.model.Order;
import com.anuwat.food_order_online.model.User;
import com.anuwat.food_order_online.service.OrderService;
import com.anuwat.food_order_online.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminOrderController {

    private final OrderService orderService;

    private final UserService userService;

    public AdminOrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/order/restaurant/{id}")
    public ResponseEntity<List<Order>> getOrderHistory(@PathVariable Long id,
                                                       @RequestParam(required = false) String order_status,
                                                       @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        List<Order> orders = orderService.getRestaurantsOrder(id, order_status);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping("/order/{id}/{orderStatus}")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long id,
                                                   @PathVariable String orderStatus,
                                                   @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        Order order = orderService.updateOrderStatus(id, orderStatus);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
