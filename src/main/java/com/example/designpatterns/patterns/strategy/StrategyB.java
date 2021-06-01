package com.example.designpatterns.patterns.strategy;

/**
 * @author jc
 * @version 1.0.0
 * @className StrategyB
 * @description
 * @date 2021/6/1
 */
public class StrategyB implements Strategy{
    @Override
    public void operate() {
        System.out.println("strategy b");
    }
}
