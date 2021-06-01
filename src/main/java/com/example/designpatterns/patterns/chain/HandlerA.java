package com.example.designpatterns.patterns.chain;

/**
 * @author jc
 * @version 1.0.0
 * @className HandlerA
 * @description
 * @date 2021/6/1
 */
public class HandlerA extends Handler {
    @Override
    public void handlerRequest() {
        System.out.println("do request a");
        if (getNext() != null) {
            getNext().handlerRequest();
        } else {
            System.out.println("over");
        }
    }
}
