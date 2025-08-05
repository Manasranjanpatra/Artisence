package com.ecommerce.ecommerce.order.service;

import java.util.List;

import com.ecommerce.ecommerce.global.Status;
import com.ecommerce.ecommerce.order.model.Order;
import com.ecommerce.ecommerce.order.model.OrderDto;

public interface OrderService {

    Status saveOrUpdate(OrderDto orderDto);

    Status deleteOrderById(Long id);

    Order findByOrderId(Long id);

    List<OrderDto> listByStoreId(Long id);

    List<OrderDto> listByUserId(Long id);

    Status updateStatus(Long id,String status);
    
}
