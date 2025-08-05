package com.ecommerce.ecommerce.products.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import com.ecommerce.ecommerce.global.Status;
import com.ecommerce.ecommerce.products.entity.Product;
import com.ecommerce.ecommerce.products.entity.ProductDTO;
import com.ecommerce.ecommerce.products.entity.ProductFilter;
import com.ecommerce.ecommerce.products.entity.ProductProj;

public interface ProductService {
    
    
    // List<ProductDTO> listByUserId(Long id);

    List<ProductDTO> findAllByProductByName(String name);

    List<ProductDTO> findAllByCategory(Long category);

    ProductDTO findByProductId(Long id);

    Status saveOrUpdate(ProductDTO productDTO,MultipartFile file);

    Status deleteProductById(Long id);

    List<Product> listByStoreId();

    Status issueBill(List<ProductDTO> productList);

    List<ProductProj> frilterProduct(ProductFilter filter);

    List<Product> fetchSellerProducts(Long id);

    Page<ProductProj> frilterLatestProduct(Pageable pageable);


}
