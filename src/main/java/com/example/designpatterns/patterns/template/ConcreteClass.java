package com.example.designpatterns.patterns.template;

/**
 * @author jc
 * @version 1.0.0
 * @className ConcreteClass
 * @description
 * @date 2021/6/1
 */
public class ConcreteClass extends AbstractClass {
    @Override
    public void abstractMethod() {
        System.out.println("子类实现方法");
    }
}
