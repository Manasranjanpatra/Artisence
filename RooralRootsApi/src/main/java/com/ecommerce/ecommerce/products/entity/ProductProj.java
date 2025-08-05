package com.ecommerce.ecommerce.products.entity;

import com.ecommerce.ecommerce.category.model.Category;
import com.ecommerce.ecommerce.users.Entity.User;

public interface ProductProj {

     Long getId();

     String getImage();

     String getName();

     Double getPrice();

     Category getCategory();

     String getDescription();



     String getSellunit();

     User getSeller();
}
