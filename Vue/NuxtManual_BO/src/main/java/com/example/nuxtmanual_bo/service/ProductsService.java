package com.example.nuxtmanual_bo.service;

import com.example.nuxtmanual_bo.model.ProductsDto;

import java.util.List;

public interface ProductsService {

    List<ProductsDto.ProductsList> productsList(ProductsDto.ProductsListParam productsListParam);

    // id값을 통해 특정 상품의 detail 조회
    ProductsDto.detail detail(Long product_id);
}
