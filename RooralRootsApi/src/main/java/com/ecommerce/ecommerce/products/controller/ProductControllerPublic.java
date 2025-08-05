package com.ecommerce.ecommerce.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ecommerce.ecommerce.global.Status;
import com.ecommerce.ecommerce.products.entity.Product;
import com.ecommerce.ecommerce.products.entity.ProductDTO;
import com.ecommerce.ecommerce.products.entity.ProductFilter;
import com.ecommerce.ecommerce.products.entity.ProductProj;
import com.ecommerce.ecommerce.products.service.ProductService;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/v1/public/api/product")
public class ProductControllerPublic {
   
@Autowired
private ProductService pService;

    @PostMapping("/filter")
    public List<ProductProj> frilterProduct(@RequestBody ProductFilter filter){
        return pService.frilterProduct(filter);
    }

    @GetMapping("/filter-latest")
    public Page<ProductProj> frilterLatestProduct(Pageable pageable){
        return pService.frilterLatestProduct(pageable);
    }
    
    @GetMapping("/seller-products/id/{id}")
    public List<Product> fetchSellerProducts(@PathVariable Long id){
        return pService.fetchSellerProducts(id);
    }
}






