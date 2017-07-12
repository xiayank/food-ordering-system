package com.nic.service.impl;

import com.nic.model.MenuItem;
import com.nic.repository.MenuItemRepository;
import com.nic.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by NIC on 7/9/17.
 */
@Service
public class MenuItemServiceImpl implements MenuItemService{
    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository){
        this.menuItemRepository = menuItemRepository;
    }



    @Override
    public List<MenuItem> findAllByRestaurantId(String RestaurantId) {
        return menuItemRepository.findAllByRestaurantId(RestaurantId);
    }

    @Override
    public void createMenuItems(MenuItem menuItem) {
        menuItemRepository.save(menuItem);
    }

    @Override
    public void uploadMenuItems(List<MenuItem> menuItemList) {
        menuItemRepository.save(menuItemList);
    }
}
