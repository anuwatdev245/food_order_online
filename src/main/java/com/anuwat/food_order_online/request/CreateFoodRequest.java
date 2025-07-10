package com.anuwat.food_order_online.request;

import com.anuwat.food_order_online.model.Category;
import com.anuwat.food_order_online.model.IngredientsItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateFoodRequest {

    private String name;

    private String description;

    private Long price;

    private Category category;

    private List<String> images;

    private Long restaurantId;

    private boolean Vegetarian;

    private boolean seasonal;

    private List<IngredientsItem> ingredients;
}
