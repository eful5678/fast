package com.example.nuxtmanual_bo.service;

import com.example.nuxtmanual_bo.model.ProductsDto;

import java.util.List;

public interface ProductsService {

    List<ProductsDto.ProductsList> productsList(ProductsDto.ProductsListParam productsListParam);
}
