package com.example.designpatterns.patterns.strategy;

/**
 * @author jc
 * @version 1.0.0
 * @className StrategyA
 * @description
 * @date 2021/6/1
 */
public class StrategyA implements Strategy {
    @Override
    public void operate() {
        System.out.println("strategy a");
    }
}
