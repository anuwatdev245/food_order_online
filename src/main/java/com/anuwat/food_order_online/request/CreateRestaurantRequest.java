package com.anuwat.food_order_online.request;

import com.anuwat.food_order_online.model.Address;
import com.anuwat.food_order_online.model.ContactInformation;
import lombok.Data;

import java.util.List;

@Data
public class CreateRestaurantRequest {

    private Long id;

    private String name;

    private String description;

    private String cuisineType;

    private Address address;

    private ContactInformation contactInformation;

    private String openingHours;

    private List<String> image;

}
