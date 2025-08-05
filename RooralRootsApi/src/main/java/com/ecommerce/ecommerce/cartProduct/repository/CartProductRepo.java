package com.ecommerce.ecommerce.cartProduct.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.cartProduct.entity.CartProduct;

public interface CartProductRepo extends JpaRepository<CartProduct,Long>{

    boolean existsByBuyer_idAndProduct_idAndIdNot(Long id, Long id2, Long long1);

    List<CartProduct> findAllByBuyer_id(Long id);
    
}
