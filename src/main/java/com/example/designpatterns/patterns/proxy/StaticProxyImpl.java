package com.example.designpatterns.patterns.proxy;

/**
 * className StaticProxyOb
 * date 2021/2/18
 *
 * @author JC
 */
public class StaticProxyImpl implements StaticProxy{
    private StaticProxy actual;

    public StaticProxyImpl(StaticProxy actual) {
        this.actual = actual;
    }

    @Override
    public void print() {
        System.out.println("代理的");
        actual.print();
    }
}
