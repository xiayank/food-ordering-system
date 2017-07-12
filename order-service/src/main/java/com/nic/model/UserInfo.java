package com.nic.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embeddable;

/**
 * Created by NIC on 7/12/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Document
@Embeddable
public class UserInfo {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
}
