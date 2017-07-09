package com.nic.service;

import com.nic.model.MenuItem;

import java.util.List;

/**
 * Created by NIC on 7/9/17.
 */
public interface MenuItemService {

    List<MenuItem> findAllByRestaurantId(String RestaurantId);

    void createMenuItems(MenuItem menuItem);

    void uploadMenuItems(List<MenuItem> menuItemList);
}
