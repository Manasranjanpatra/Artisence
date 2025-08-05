package com.ecommerce.ecommerce.cartProduct.service;

import java.util.List;

import com.ecommerce.ecommerce.cartProduct.entity.CartProduct;
import com.ecommerce.ecommerce.cartProduct.entity.CartProductDTO;
import com.ecommerce.ecommerce.global.Status;

public interface CartProdectService {

    CartProductDTO findByCartProductId(Long id);

    Status saveOrUpdate(CartProductDTO cartProductDTO);

    Status deleteCartProductById(Long id);

    List<CartProduct> myCartList();
    
}
