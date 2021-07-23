package com.example.designpatterns.patterns.bridge;

/**
 * @author jc
 * @version 1.0.0
 * @className ColorAdapter
 * @description
 * @date 2021-07-23
 */
public class ColorAdapter implements Color {

    private SpecialColor specialColor;

    public ColorAdapter(SpecialColor specialColor) {
        this.specialColor = specialColor;
    }

    @Override
    public String getColor() {
        return specialColor.getSpecialColor();
    }
}
