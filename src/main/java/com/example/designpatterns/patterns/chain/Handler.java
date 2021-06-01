package com.example.designpatterns.patterns.chain;

/**
 * @author jc
 * @version 1.0.0
 * @className Handler
 * @description
 * @date 2021/6/1
 */
public abstract class Handler {
    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handlerRequest();
}
