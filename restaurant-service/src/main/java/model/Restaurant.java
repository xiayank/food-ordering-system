package model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
/**
 * Created by NIC on 7/7/17.
 */
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Restaurant {

    @Id
    String id;

    String name;
}
