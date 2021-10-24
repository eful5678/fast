package com.example.nuxtmanual_bo.api;

import com.example.nuxtmanual_bo.model.ProductsDto;
import com.example.nuxtmanual_bo.service.ProductsService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5000")
public class ProductsRestController {

    private final ProductsService productsService;

    @GetMapping("/list")
    List<ProductsDto.ProductsList> productsList(@ModelAttribute ProductsDto.ProductsListParam productsListParam){
        System.out.println("ddd");
        return productsService.productsList(productsListParam);
    }

    @GetMapping("/{id}")
    ProductsDto.detail detail(@PathVariable Optional<Long> id){
        return productsService.detail(id.get());
    }

}
