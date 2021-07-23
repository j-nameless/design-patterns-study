package com.example.designpatterns.patterns.singleton;

/**
 * className EnumSingleton
 * date 2021/2/18
 *
 * @author JC
 */
public enum  EnumSingleton {
    //单例模式
    INSTANCE;

    public void doSomething(){
        System.out.println("do something");
    }
}
