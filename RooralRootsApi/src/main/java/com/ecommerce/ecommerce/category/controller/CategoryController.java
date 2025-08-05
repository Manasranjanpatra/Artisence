package com.ecommerce.ecommerce.category.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.category.model.Category;
import com.ecommerce.ecommerce.category.repository.CategoryRepo;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    

    private final CategoryRepo categoryRepo;

    @GetMapping("/list")
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
}
