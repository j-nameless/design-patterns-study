package com.example.designpatterns.patterns.factory.abstract_factory;

import com.example.designpatterns.patterns.factory.*;

/**
 * className HuaWeiFactory
 * date 2021/2/18
 *
 * @author JC
 */
public class HuaWeiFactory implements AbstractFactory{

    @Override
    public Phone makePhone() {
        return new HuaWeiPhone();
    }

    @Override
    public Computer makeComputer() {
        return new HuaWeiComputer();
    }
}
