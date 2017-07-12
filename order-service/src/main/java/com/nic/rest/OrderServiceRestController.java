package com.nic.rest;

import com.nic.model.Order;
import com.nic.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NIC on 7/12/17.
 */
@RestController
public class OrderServiceRestController {
    OrderService orderService;

    @Autowired
    public OrderServiceRestController(OrderService orderService){
        this.orderService = orderService;
    }
    @RequestMapping(value = "/restaurants/orders")
    public void createOrder(Order order){
        orderService.createOrder(order);
    }
}
