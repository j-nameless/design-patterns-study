package com.example.designpatterns.patterns.decorator;

/**
 * @author jc
 * @version 1.0.0
 * @className CookCake
 * @description
 * @date 2021/5/28
 */
public class CookCake implements Cake {

    private Cake cake;

    public CookCake(Cake cake) {
        this.cake = cake;
    }

    @Override
    public void getCake() {
        cake.getCake();
        System.out.println("给饼翻个面");
        System.out.println("再翻个面");
    }
}
