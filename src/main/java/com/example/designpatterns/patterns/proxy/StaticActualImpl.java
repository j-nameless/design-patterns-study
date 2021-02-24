package com.example.designpatterns.patterns.proxy;

/**
 * className ActualOb
 * date 2021/2/18
 *
 * @author JC
 */
public class StaticActualImpl implements StaticProxy{
    @Override
    public void print() {
        System.out.println("真实的对象");
    }
}
