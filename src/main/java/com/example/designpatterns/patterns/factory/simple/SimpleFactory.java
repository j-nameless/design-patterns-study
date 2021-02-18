package com.example.designpatterns.patterns.factory.simple;

import com.example.designpatterns.patterns.factory.Product;
import com.example.designpatterns.patterns.factory.Product1;
import com.example.designpatterns.patterns.factory.Product2;

/**
 * className SimpleFactory
 * date 2021/2/18
 *
 * @author JC
 */
public class SimpleFactory {

    public static Product mackProduct(int kid) {
        switch (kid) {
            case 1:
                return new Product1();
            case 2:
                return new Product2();
            default:
                return null;
        }
    }
}
