package com.nic.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Created by NIC on 7/7/17.
 */
@RequiredArgsConstructor(onConstructor = @__(@PersistenceConstructor))
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuItem {
    @Id
    String id;

    private String restaurantId;
    private String name;
    private String description;
    private int price;



}
