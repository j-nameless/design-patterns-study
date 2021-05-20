package com.example.designpatterns.patterns.factory.abstract_factory;

import com.example.designpatterns.patterns.factory.*;

/**
 * className AppleFactory
 * date 2021/2/18
 *
 * @author JC
 */
public class AppleFactory implements AbstractFactory{

    @Override
    public Phone makePhone() {
        return new IPhone();
    }

    @Override
    public Computer makeComputer() {
        return new MacComputer();
    }
}
