
package com.ecommerce.ecommerce.cartProduct.entity;


import java.util.Date;
import com.ecommerce.ecommerce.products.entity.ProductDTO;
import com.ecommerce.ecommerce.users.Entity.User;
import com.ecommerce.ecommerce.users.Entity.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartProductDTO {

    
    private Long id;
   private UserDTO buyer;
    private ProductDTO product;
    private Float quantity;
    private Float totalcost;
    private Date createdon;

    public CartProductDTO(CartProduct cartProduct){
        this.id=cartProduct.getId();
        this.product=new ProductDTO(cartProduct.getProduct());
        this.buyer=new UserDTO(cartProduct.getBuyer());
        this.quantity=cartProduct.getQuantity();
        this.createdon=cartProduct.getCreatedon();
    }

}