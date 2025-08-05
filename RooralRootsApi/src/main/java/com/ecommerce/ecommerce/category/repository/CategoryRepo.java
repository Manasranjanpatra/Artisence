package com.ecommerce.ecommerce.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.category.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
 
}
