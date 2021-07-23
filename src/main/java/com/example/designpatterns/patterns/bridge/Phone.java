package com.example.designpatterns.patterns.bridge;

/**
 * @author jc
 * @version 1.0.0
 * @className Phone
 * @description
 * @date 2021/5/21
 */
public abstract class Phone {
    protected Color color;

    public Phone(Color color) {
        this.color = color;
    }

    public abstract String getInfo();
}
