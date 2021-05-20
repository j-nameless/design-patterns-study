package com.example.designpatterns.patterns.factory.abstract_factory;

import com.example.designpatterns.patterns.factory.*;

/**
 * className ComputerFactory
 * date 2021/2/18
 * 电脑工厂
 * @author JC
 */
public class ComputerFactory implements AbstractFactory{

    @Override
    public Apple makeApple() {
        return new Mac();
    }

    @Override
    public HuaWei makeHuaWei() {
        return new HuaWeiComputer();
    }
}
