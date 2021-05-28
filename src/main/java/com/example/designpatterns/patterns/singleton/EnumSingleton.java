package com.example.designpatterns.patterns.singleton;

/**
 * className EnumSingleton
 * date 2021/2/18
 *
 * @author JC
 */
public enum  EnumSingleton {
    INSTANCE;

    public void doSomething(){
        System.out.println("do something");
    }
}
