

package com.ecommerce.ecommerce.cartProduct.entity;

import java.util.Date;

import com.ecommerce.ecommerce.products.entity.Product;
import com.ecommerce.ecommerce.users.Entity.User;
import com.ecommerce.ecommerce.users.Entity.UserDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CartProduct {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Float quantity;
    private Date createdon;

    public CartProduct(CartProductDTO cartProduct){
        this.id=cartProduct.getId();
        this.buyer=new User(cartProduct.getBuyer());
        this.product=new Product(cartProduct.getProduct());
        this.quantity=cartProduct.getQuantity();
        this.createdon=cartProduct.getCreatedon();
    }
}