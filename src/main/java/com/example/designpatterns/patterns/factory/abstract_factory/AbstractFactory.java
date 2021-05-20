package com.example.designpatterns.patterns.factory.abstract_factory;

import com.example.designpatterns.patterns.factory.Phone;
import com.example.designpatterns.patterns.factory.Computer;

/**
 * className AbstractFactory
 * date 2021/2/18
 *
 * @author JC
 */
public interface AbstractFactory {
    Phone makePhone();
    Computer makeComputer();
}
