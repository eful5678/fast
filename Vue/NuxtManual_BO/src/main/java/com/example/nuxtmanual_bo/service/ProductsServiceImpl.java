package com.example.nuxtmanual_bo.service;

import com.example.nuxtmanual_bo.model.ProductsDto;
import com.example.nuxtmanual_bo.repository.ProductsRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepositorySupport productsRepositorySupport;

    @Override
    public List<ProductsDto.ProductsList> productsList(ProductsDto.ProductsListParam productsListParam) {

        return productsRepositorySupport.productsList(productsListParam);
    }
}
