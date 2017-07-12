package com.nic.service.impl;

import com.nic.model.Restaurant;
import com.nic.repository.RestaurantRepository;
import com.nic.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by NIC on 7/9/17.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurantByName(String name) {
        return restaurantRepository.findFirstByName(name);

    }
}
