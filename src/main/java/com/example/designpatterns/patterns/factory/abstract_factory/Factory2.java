package com.example.designpatterns.patterns.factory.abstract_factory;

import com.example.designpatterns.patterns.factory.*;

/**
 * className Factory1
 * date 2021/2/18
 *
 * @author JC
 */
public class Factory2 implements AbstractFactory{

    @Override
    public Product makeProduct() {
        return new Product2();
    }

    @Override
    public ProductS makeProductS() {
        return new ProductS2();
    }
}
