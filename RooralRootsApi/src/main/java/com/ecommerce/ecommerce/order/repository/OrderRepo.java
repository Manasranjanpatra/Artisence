package com.ecommerce.ecommerce.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.order.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long>{

    List<Order> findAllBySeller_idOrderByOrderdateDesc(Long id);

    List<Order> findAllByBuyer_id(Long id);
    
}
