package com.ecommerce.ecommerce.products.entity;

import com.ecommerce.ecommerce.category.model.Category;
import com.ecommerce.ecommerce.users.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {

    private Long id;
    private String image;
    private String name;
    private Double price;
    private Category category;
    private String description;
    private Long deliverPrice;
    private String sellunit;
    private User seller;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.image = product.getImage();
        this.name = product.getName();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.description = product.getDescription();
        this.sellunit = product.getSellunit();
        this.deliverPrice=product.getDeliverPrice();
    }
}
