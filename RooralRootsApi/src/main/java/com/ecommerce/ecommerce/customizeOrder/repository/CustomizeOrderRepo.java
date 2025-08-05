package com.ecommerce.ecommerce.customizeOrder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.customizeOrder.model.CustomizeOrder;

@Repository
public interface CustomizeOrderRepo extends JpaRepository<CustomizeOrder,Long>{

    List<CustomizeOrder> findAllBySeller_id(Long id);

    List<CustomizeOrder> findAllByBuyer_id(Long id);
    
}
