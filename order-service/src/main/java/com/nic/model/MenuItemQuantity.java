package com.nic.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embeddable;

/**
 * Created by NIC on 7/12/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Document
@Embeddable
public class MenuItemQuantity {
    private String name;
    private int price;
    private int quantity;
}
