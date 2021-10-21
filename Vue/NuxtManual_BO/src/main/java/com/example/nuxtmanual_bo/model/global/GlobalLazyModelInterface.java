package com.example.nuxtmanual_bo.model.global;

@FunctionalInterface
public interface GlobalLazyModelInterface<T, R> {

    R lazyModeling(T t);
}
