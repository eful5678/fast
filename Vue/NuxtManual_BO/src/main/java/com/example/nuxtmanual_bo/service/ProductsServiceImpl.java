package com.example.nuxtmanual_bo.service;

import com.example.nuxtmanual_bo.model.ProductsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Override
    public List<ProductsDto.ProductsList> productsList(ProductsDto.ProductsListParam productsListParam) {
        return null;
    }
}
