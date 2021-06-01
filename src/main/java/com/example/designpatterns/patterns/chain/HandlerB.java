package com.example.designpatterns.patterns.chain;

/**
 * @author jc
 * @version 1.0.0
 * @className HandlerB
 * @description
 * @date 2021/6/1
 */
public class HandlerB extends Handler {
    @Override
    public void handlerRequest() {
        System.out.println("do request b");
        if (getNext() != null) {
            getNext().handlerRequest();
        } else {
            System.out.println("over");
        }
    }
}
