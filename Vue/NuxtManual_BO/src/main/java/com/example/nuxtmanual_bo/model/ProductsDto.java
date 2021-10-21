package com.example.nuxtmanual_bo.model;

import com.example.nuxtmanual_bo.domain.Products;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
public class ProductsDto {

    public static class ProductsListParam{

    }

    @Getter
    @Setter
    public static class ProductsList{
        private String name;

        private BigDecimal price;

        public ProductsList(Products products){
            this.name = products.getName();
            this.price = products.getPrice();
        }
    }


}
