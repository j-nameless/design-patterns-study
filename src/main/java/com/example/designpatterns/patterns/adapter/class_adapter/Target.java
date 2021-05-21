package com.example.designpatterns.patterns.adapter.class_adapter;

/**
 * @author jc
 * @version 1.0.0
 * @className Tagert
 * @description
 * @date 2021/5/20
 */
public class Target {
    public void targetRequest(){
        System.out.println("被适配接口的方法被调用");
    }
}
