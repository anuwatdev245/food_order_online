package com.anuwat.food_order_online.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {



    private String streetAddress;

    private String city;

    private String stateProvince;

    private String postalCode;

    private String country;

}
