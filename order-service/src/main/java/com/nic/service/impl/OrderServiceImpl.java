package com.nic.service.impl;

import com.nic.model.Order;
import com.nic.repository.OrderRespository;
import com.nic.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by NIC on 7/12/17.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRespository orderRespository;

    @Autowired
    public OrderServiceImpl(OrderRespository orderRespository){
            this.orderRespository = orderRespository;
    }

    @Override
    public void createOrder(Order order) {
        order.setOrderTime(System.currentTimeMillis());
        order.setTotalPrice(order.getMenuItemList().stream().mapToInt(e -> e.getPrice() * e.getQuantity()).sum());
        orderRespository.save(order);
    }
}
