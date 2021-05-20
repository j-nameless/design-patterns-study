package com.example.designpatterns.patterns.factory.simple;

import com.example.designpatterns.patterns.factory.Apple;
import com.example.designpatterns.patterns.factory.HuaWeiPhone;
import com.example.designpatterns.patterns.factory.IPhone;
import com.example.designpatterns.patterns.factory.Mac;
import com.example.designpatterns.patterns.factory.enums.AppleEnum;

/**
 * className SimpleFactory
 * date 2021/2/18
 * 简单工厂 生产一个产品簇的
 * @author JC
 */
public class SimpleFactory {

    public static Apple mackProduct(AppleEnum kid) {
        switch (kid) {
            case MAC:
                return new Mac();
            case IPHONE:
                return new IPhone();
            default:
                return null;
        }
    }
}
