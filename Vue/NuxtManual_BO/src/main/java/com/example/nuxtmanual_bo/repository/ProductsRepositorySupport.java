package com.example.nuxtmanual_bo.repository;

import com.example.nuxtmanual_bo.model.ProductsDto;

import java.util.List;

public interface ProductsRepositorySupport {

    List<ProductsDto.ProductsList> productsList(ProductsDto.ProductsListParam productsListParam);
    
    // 상품정보 조회
    ProductsDto.detail detail(Long id);
}
