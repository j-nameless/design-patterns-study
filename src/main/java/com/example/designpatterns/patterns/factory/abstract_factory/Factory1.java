package com.example.designpatterns.patterns.factory.abstract_factory;

import com.example.designpatterns.patterns.factory.Product;
import com.example.designpatterns.patterns.factory.Product1;
import com.example.designpatterns.patterns.factory.ProductS;
import com.example.designpatterns.patterns.factory.ProductS1;

/**
 * className Factory1
 * date 2021/2/18
 *
 * @author JC
 */
public class Factory1 implements AbstractFactory{

    @Override
    public Product makeProduct() {
        return new Product1();
    }

    @Override
    public ProductS makeProductS() {
        return new ProductS1();
    }
}
