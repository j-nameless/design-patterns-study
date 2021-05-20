package com.example.designpatterns.patterns.factory.abstract_factory;

import com.example.designpatterns.patterns.factory.*;

/**
 * className PhoneFactory
 * date 2021/2/18
 * 手机工厂
 * @author JC
 */
public class PhoneFactory implements AbstractFactory{

    @Override
    public Apple makeApple() {
        return new IPhone();
    }

    @Override
    public HuaWei makeHuaWei() {
        return new HuaWeiPhone();
    }
}
