package com.ecommerce.ecommerce.products.entity;


import com.ecommerce.ecommerce.category.model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OnlyProductDTO {
    

    private Long id;
    private String image;
    private String name;
    private boolean available;
    private Double price;
    private String discount;
    private String brand;
    private Category category;
    private String description;
    private Float sellunit;
}
