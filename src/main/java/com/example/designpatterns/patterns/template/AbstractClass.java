package com.example.designpatterns.patterns.template;

/**
 * @author jc
 * @version 1.0.0
 * @className AbstractClass
 * @description
 * @date 2021/6/1
 */
public abstract class AbstractClass {
    public void templateMethod() {
        specialMethod();
        abstractMethod();
    }

    public void specialMethod() {
        System.out.println("父类方法");
    }

    public abstract void abstractMethod();
}
