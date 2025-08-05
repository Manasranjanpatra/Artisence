package com.ecommerce.ecommerce.cartProduct.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.ecommerce.ecommerce.cartProduct.entity.CartProduct;
import com.ecommerce.ecommerce.cartProduct.entity.CartProductDTO;
import com.ecommerce.ecommerce.cartProduct.repository.CartProductRepo;
import com.ecommerce.ecommerce.global.Status;
import com.ecommerce.ecommerce.products.entity.Product;
import com.ecommerce.ecommerce.users.Entity.User;
import com.ecommerce.ecommerce.users.Repository.UserRepo;
import com.ecommerce.ecommerce.users.service.UserServiceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CartProdectServiceImpl implements CartProdectService {

  @Autowired
  CartProductRepo cProductRepo;

  @Autowired
  UserServiceImpl userServiceImpl;

  @Autowired
  UserRepo userRepo;

  @Autowired
  CartProductRepo cartRepo;

  CartProduct delCartProduct;

  private Float priceOfAllObj = (float) 0;

  @Override
  public Status deleteCartProductById(Long id) {
    cProductRepo.findById(id).ifPresentOrElse(
        country -> {
          cProductRepo.deleteById(id);
        },
        () -> {
          throw new EntityNotFoundException("cart product not found with ID: " + id);
        });
    return new Status(true, "Deleted Successfully");
  }

  @Override
  public CartProductDTO findByCartProductId(Long id) {
    return cProductRepo.findById(id).map(CartProductDTO::new)
        .orElseThrow(() -> new EntityNotFoundException("Cart Product  not found with ID: " + id));
  }

  @Override
  public Status saveOrUpdate(CartProductDTO cartProductDTO) {

    try {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      User buyer = userRepo.findByPhone(authentication.getName());

      boolean isExists=cartRepo.existsByBuyer_idAndProduct_idAndIdNot(buyer.getId(),cartProductDTO.getProduct().getId(),
      cartProductDTO.getId()!=null?cartProductDTO.getId():null);

      if(isExists){
        return new Status(false, "Product already in cart");
      }

      return new Status(true, cartProductDTO.getId() == null ? "successfuly added" : "update successfuly");
    } catch (Exception e) {
      log.error("error while adding cart product");
      return new Status(false, "An error occurred");
    }
  }

  // <update cart product>
  public CartProduct setCartProduct(CartProductDTO cProductDTO) {
    return cProductRepo.findById(cProductDTO.getId())
        .map(existObj -> {
          existObj.setQuantity(cProductDTO.getQuantity());
          return existObj;
        }).orElseThrow(() -> new EntityNotFoundException("Cart product not found with ID: " +
            cProductDTO.getId()));
  }
  // </update cart product>

  @Override
  public List<CartProduct> myCartList() {
    List<CartProduct> products=new ArrayList<>();
  try {
    Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
    User buyer=userRepo.findByPhone(authentication.getName());
    products=cartRepo.findAllByBuyer_id(buyer.getId());
  } catch (Exception e) {
  }
  return products;
  }
}
