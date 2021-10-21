package com.example.nuxtmanual_bo.api;

import com.example.nuxtmanual_bo.model.ProductsDto;
import com.example.nuxtmanual_bo.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
