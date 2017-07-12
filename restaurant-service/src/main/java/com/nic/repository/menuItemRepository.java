package com.nic.repository;

import com.nic.model.MenuItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by NIC on 7/7/17.
 */
@RepositoryRestResource(collectionResourceRel = "menuItems")
public interface MenuItemRepository extends PagingAndSortingRepository<MenuItem, String>{
    @RestResource(rel = "byRestaurantId")
    List<MenuItem> findAllByRestaurantId(@Param("restaurantId") String restaurantId);

}
