package com.nic.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embedded;
import java.util.List;

/**
 * Created by NIC on 7/12/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Document
public class Order {
    @Id
    private String id;

    @Embedded
    private List<MenuItemQuantity> menuItemList;

    @Embedded
    private UserInfo userInfo;

    private String restaurantId;
    private int totalPrice;
    private long orderTime;
    private String specialNote;
    private long deliveryTime;
    private String paymentId;

}
