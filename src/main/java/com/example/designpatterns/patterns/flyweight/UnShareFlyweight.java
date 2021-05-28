package com.example.designpatterns.patterns.flyweight;

/**
 * @author jc
 * @version 1.0.0
 * @className UnshareFlyweight
 * @description
 * @date 2021/5/28
 */
public class UnShareFlyweight {
    private String unShareInfo;

    public UnShareFlyweight(String unShareInfo) {
        this.unShareInfo = unShareInfo;
    }

    public String getUnShareInfo() {
        return unShareInfo;
    }

    public void setUnShareInfo(String unShareInfo) {
        this.unShareInfo = unShareInfo;
    }
}
