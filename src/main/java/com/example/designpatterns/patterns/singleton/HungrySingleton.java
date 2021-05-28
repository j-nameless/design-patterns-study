package com.example.designpatterns.patterns.singleton;

/**
 * className HungrySingleton
 * date 2021/2/18
 *
 * @author JC
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return instance;
    }

    public void doSomething() {
        System.out.println("do something");
    }
}
