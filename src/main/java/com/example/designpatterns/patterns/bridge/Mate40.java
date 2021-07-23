package com.example.designpatterns.patterns.bridge;

/**
 * @author jc
 * @version 1.0.0
 * @className Mate40
 * @description
 * @date 2021-07-23
 */
public class Mate40 extends Phone {
    public Mate40(Color color) {
        super(color);
    }

    @Override
    public String getInfo() {
        return color.getColor()+" Mate40";
    }
}
