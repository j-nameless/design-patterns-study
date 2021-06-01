package com.example.designpatterns.patterns.observe;



/**
 * @author jc
 * @version 1.0.0
 * @className EventListenerA
 * @description
 * @date 2021/6/1
 */
public class EventListenerA implements Listener {

    @Override
    public void exc(Event e) {
        if (e.isFlag()) {
            System.out.println("a true");
        } else {
            System.out.println("a false");
        }
    }
}
