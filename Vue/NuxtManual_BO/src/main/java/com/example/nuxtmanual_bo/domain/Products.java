package com.example.nuxtmanual_bo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Products {

    @Id
    @GeneratedValue
    @Column(name = "products_id")
    private Long id;

    @Column
    private String name;

    @Column
    private BigDecimal price;
}
