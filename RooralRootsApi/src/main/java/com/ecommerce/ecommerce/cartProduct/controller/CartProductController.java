package com.ecommerce.ecommerce.cartProduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.cartProduct.entity.CartProduct;
import com.ecommerce.ecommerce.cartProduct.entity.CartProductDTO;
import com.ecommerce.ecommerce.cartProduct.service.CartProdectService;
import com.ecommerce.ecommerce.global.Status;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/cart-product")
public class CartProductController {

       
@Autowired
private CartProdectService cPService;


    // @GetMapping(value="/list")
    // public List<ProductDTO> findAllByCategory(){
    //     return cPService.findListForauthuser();
    // }
    @GetMapping(value="/id/{id}")
    public CartProductDTO getById(@PathVariable Long id ){
        return cPService.findByCartProductId(id);
    }
   @PostMapping(name = "/saveorupdate")
    public Status saveOrUpdateCartProduct(@RequestBody CartProductDTO cartProductDTO){
        return cPService.saveOrUpdate(cartProductDTO);
    }

    @DeleteMapping(value="/delete/id/{id}")
    public Status deleteById(@PathVariable Long id ){
        return cPService.deleteCartProductById(id);
    }

    @GetMapping(value="/my-cart/list")
    public List<CartProduct> myCartList( ){
        return cPService.myCartList();
    }



}
