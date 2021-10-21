package com.example.nuxtmanual_bo.repository;

import com.example.nuxtmanual_bo.model.ProductsDto;

import java.util.List;

public interface ProductsRepositorySupport {

    List<ProductsDto.ProductsList> productsList(ProductsDto.ProductsListParam productsListParam);
}
