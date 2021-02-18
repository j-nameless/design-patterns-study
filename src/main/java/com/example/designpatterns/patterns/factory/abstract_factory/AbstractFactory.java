package com.example.designpatterns.patterns.factory.abstract_factory;

import com.example.designpatterns.patterns.factory.Product;
import com.example.designpatterns.patterns.factory.ProductS;

/**
 * className AbstractFactory
 * date 2021/2/18
 *
 * @author JC
 */
public interface AbstractFactory {
    Product makeProduct();
    ProductS makeProductS();
}
