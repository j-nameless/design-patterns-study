package com.example.designpatterns.patterns.bridge;

/**
 * @author jc
 * @version 1.0.0
 * @className IPhone
 * @description
 * @date 2021/5/21
 */
public class IPhone extends Phone {
    public IPhone(Color color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color.getColor();
    }

}
