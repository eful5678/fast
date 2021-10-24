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

        private String imageUrl;

        private Long id;

        public ProductsList(Products products){
            this.name = products.getName();
            this.price = products.getPrice();
            this.imageUrl = products.getImageUrl();
            this.id = products.getId();
        }
    }

    @Getter
    @Setter
    public static class detail{
        private Long id;

        public detail(Products products){
            this.id = products.getId();
        }
    }


}
