package com.anuwat.food_order_online.request;

import com.anuwat.food_order_online.model.Address;
import lombok.Data;

@Data
public class OrderRequest {

    private Long restaurantId;

    private Address deliveryAddress;

}
