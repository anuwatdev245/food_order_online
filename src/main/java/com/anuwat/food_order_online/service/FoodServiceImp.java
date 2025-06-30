package com.anuwat.food_order_online.service;

import com.anuwat.food_order_online.model.Category;
import com.anuwat.food_order_online.model.Food;
import com.anuwat.food_order_online.model.Restaurant;
import com.anuwat.food_order_online.repository.FoodRepository;
import com.anuwat.food_order_online.request.CreateFoodRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImp implements FoodService{

    private final FoodRepository foodRepository;

    public FoodServiceImp(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant) {
        return null;
    }

    @Override
    public void deleteFood(Long foodId) throws Exception {

    }

    @Override
    public List<Food> getRestaurantFood(Long restaurantId, boolean isVegetarian, boolean isNonveg, boolean isSeasonal, String foodCategory) {
        return List.of();
    }

    @Override
    public List<Food> searchFood(String keyword) {
        return List.of();
    }

    @Override
    public Food findFoodById(Long foodId) throws Exception {
        return null;
    }

    @Override
    public Food updateAvailabilityStatus(Long foodId) throws Exception {
        return null;
    }
}
