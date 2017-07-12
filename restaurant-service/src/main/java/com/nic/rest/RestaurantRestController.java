package com.nic.rest;

import com.nic.model.MenuItem;
import com.nic.model.Restaurant;
import com.nic.service.MenuItemService;
import com.nic.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/restaurants", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.createRestaurant(restaurant);
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public Restaurant findRestaurantByName(@RequestParam(value = "name") String name){
        return restaurantService.getRestaurantByName(name);

    }
    @RequestMapping(value = "/restaurants/{restaurantsId}/menuItems")
    public List<MenuItem> findAllMenuByRestaurantId(@PathVariable String restaurantsId){
        return menuItemService.findAllByRestaurantId(restaurantsId);
    }

    @RequestMapping(value = "/restaurants/menuItems", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createMenuItem(@RequestBody MenuItem menuItem){
        menuItemService.createMenuItems(menuItem);
    }

    @RequestMapping(value = "/restaurants/menuItems/upload", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void uploadMenuItems(@RequestBody List<MenuItem> menuItemList){
        menuItemService.uploadMenuItems(menuItemList);
    }

}
