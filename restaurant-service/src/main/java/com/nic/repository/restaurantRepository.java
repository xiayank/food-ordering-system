package com.nic.repository;

import com.nic.model.Restaurant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by NIC on 7/7/17.
 */
@RepositoryRestResource(path = "restaurants", collectionResourceRel= "restaurants")
public interface restaurantRepository extends PagingAndSortingRepository<Restaurant, String>{
    @RestResource(rel = "byName", description = @Description("Find by name"))
    public Restaurant findFirstByName(@Param("name") String name);
}
