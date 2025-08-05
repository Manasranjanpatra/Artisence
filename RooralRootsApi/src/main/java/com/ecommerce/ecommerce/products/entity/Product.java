package com.ecommerce.ecommerce.products.entity;

import com.ecommerce.ecommerce.category.model.Category;
import com.ecommerce.ecommerce.users.Entity.User;


import jakarta.persistence.Column;
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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
    private String name;
    private Double price;
    private Long deliverPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String description;
    private String sellunit;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    public Product(ProductDTO product) {
        this.id = product.getId();
        this.image = product.getImage();
        this.name = product.getName();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.description = product.getDescription();
        this.sellunit = product.getSellunit();
    }

}
