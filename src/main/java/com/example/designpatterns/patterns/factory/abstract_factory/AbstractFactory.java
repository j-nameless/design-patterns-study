package com.example.designpatterns.patterns.factory.abstract_factory;

import com.example.designpatterns.patterns.factory.Apple;
import com.example.designpatterns.patterns.factory.HuaWei;

/**
 * className AbstractFactory
 * date 2021/2/18
 * 抽象工厂模式  华为和Apple属于两个产品簇  phone和computer属于两个产品族  每个工厂生产一个产品族
 * @author JC
 */
public interface AbstractFactory {
    Apple makeApple();
    HuaWei makeHuaWei();
}
