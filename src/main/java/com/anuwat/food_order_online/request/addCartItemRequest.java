package com.anuwat.food_order_online.request;

import lombok.Data;

import java.util.List;

@Data
public class addCartItemRequest {

    private Long foodId;

    private int quantity;

    private List<String> ingredients;

}
