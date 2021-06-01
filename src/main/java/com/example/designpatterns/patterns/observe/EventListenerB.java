package com.example.designpatterns.patterns.observe;


/**
 * @author jc
 * @version 1.0.0
 * @className EventListenerB
 * @description
 * @date 2021/6/1
 */
public class EventListenerB implements Listener {

    @Override
    public void exc(Event e) {
        if (e.isFlag()) {
            System.out.println("b true");
        } else {
            System.out.println("b false");
        }
    }
}
