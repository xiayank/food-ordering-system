package com.nic.rest;

import com.nic.service.MenuItemService;
import com.nic.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NIC on 7/9/17.
 */
@RestController
public class RestaurantRestController {
    private RestaurantService restaurantService;
    private MenuItemService menuItemService;

    @Autowired
    public RestaurantRestController(RestaurantService restaurantService, MenuItemService menuItemService){
        this.restaurantService = restaurantService;
        this.menuItemService = menuItemService;
    }


}
