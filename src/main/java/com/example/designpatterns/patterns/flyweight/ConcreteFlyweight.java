package com.example.designpatterns.patterns.flyweight;

/**
 * @author jc
 * @version 1.0.0
 * @className ConcreteFlyweight
 * @description
 * @date 2021/5/28
 */
public class ConcreteFlyweight implements Flyweight {

    private String shareInfo;

    public ConcreteFlyweight(String shareInfo) {
        this.shareInfo = shareInfo;
    }

    @Override
    public void printInfo(UnShareFlyweight unShareFlyweight) {
        System.out.println(shareInfo);
        System.out.println(unShareFlyweight.getUnShareInfo());
    }
}
