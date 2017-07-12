package com.nic.repository;

import com.nic.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by NIC on 7/12/17.
 */
public interface OrderRespository extends PagingAndSortingRepository<Order, String> {

}
