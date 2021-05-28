package com.example.designpatterns.patterns.decorator;

/**
 * @author jc
 * @version 1.0.0
 * @className Pancake
 * @description
 * @date 2021/5/28
 */
public class Pancake implements Cake {
    @Override
    public void getCake() {
        System.out.println("取出一个饼");
    }
}
