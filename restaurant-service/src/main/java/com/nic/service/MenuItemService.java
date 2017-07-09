package com.nic.service;

import com.nic.model.MenuItem;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by NIC on 7/9/17.
 */
public interface MenuItemService  extends PagingAndSortingRepository<MenuItem, String>{
    List<MenuItem> findAllByRestaurantId();
    void createMenuItems(MenuItem menuItem);
    void uploadMenuItems(List<MenuItem> menuItemList);
}
