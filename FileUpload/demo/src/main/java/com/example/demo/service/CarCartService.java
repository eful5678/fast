package com.example.demo.service;

import com.example.demo.model.PreOrderDto;

public interface CarCartService {

    PreOrderDto.carCartList list(PreOrderDto.listParam listParam);
}
