package com.example.nuxtmanual_bo.repository;

import com.example.nuxtmanual_bo.domain.Products;
import com.example.nuxtmanual_bo.domain.QProducts;
import com.example.nuxtmanual_bo.model.ProductsDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductsRepositorySupportImpl extends QuerydslRepositorySupport implements ProductsRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public ProductsRepositorySupportImpl(EntityManager em) {
        super(Products.class);
        super.setEntityManager(em);
        jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ProductsDto.ProductsList> productsList(ProductsDto.ProductsListParam productsListParam) {
            QProducts Products = QProducts.products;
        List<ProductsDto.ProductsList> list = jpaQueryFactory.select(Projections.constructor(ProductsDto.ProductsList.class, Products))
                .from(Products)
                .fetch();

        return list;
    }

    @Override
    public ProductsDto.detail detail(Long id) {

        QProducts product = QProducts.products;

        return jpaQueryFactory.select(Projections.constructor(ProductsDto.detail.class, product))
                        .from(product)
                        .where(product.id.eq(id))
                        .fetchOne();
    }
}
