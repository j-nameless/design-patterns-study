package com.example.designpatterns.patterns.decorator;

/**
 * @author jc
 * @version 1.0.0
 * @className SauceCake
 * @description
 * @date 2021/5/28
 */
public class SauceCake extends CookCake {
    public SauceCake(Cake cake) {
        super(cake);
    }

    @Override
    public void getCake() {
        super.getCake();
        System.out.println("再来点调味料");
    }
}
