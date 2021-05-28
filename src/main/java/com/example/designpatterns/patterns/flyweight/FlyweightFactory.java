package com.example.designpatterns.patterns.flyweight;

import java.util.HashMap;

/**
 * @author jc
 * @version 1.0.0
 * @className FlyweightFactory
 * @description
 * @date 2021/5/28
 */
public class FlyweightFactory {
    private static HashMap<String, Flyweight> flyweights = new HashMap<>();

    static {
        flyweights.put("a", new ConcreteFlyweight("共享的信息"));
    }

    public static Flyweight getFlyweight(String key) {
        return flyweights.get(key);
    }
}
