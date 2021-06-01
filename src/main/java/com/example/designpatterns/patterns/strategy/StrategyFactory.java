package com.example.designpatterns.patterns.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jc
 * @version 1.0.0
 * @className StrategyFactory
 * @description
 * @date 2021/6/1
 */
public class StrategyFactory {
    private static Map<String, Strategy> strategies = new HashMap<>();

    static {
        strategies.put("a", new StrategyA());
        strategies.put("b",new StrategyB());
    }

    public static Strategy getStrategy(String strategyName) {
        return strategies.get(strategyName);
    }

    public static void operate() {
        strategies.forEach((s, strategy) -> strategy.operate());
    }
}
