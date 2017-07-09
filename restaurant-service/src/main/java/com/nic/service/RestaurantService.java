package com.nic.service;

import com.nic.model.Restaurant;

/**
 * Created by NIC on 7/9/17.
 */
public interface RestaurantService {
    void createRestaurant(Restaurant restaurant);
    Restaurant getRestaurantByName(String name);
}
