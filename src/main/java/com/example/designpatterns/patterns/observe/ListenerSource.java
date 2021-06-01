package com.example.designpatterns.patterns.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jc
 * @version 1.0.0
 * @className ListenerSource
 * @description
 * @date 2021/6/1
 */
public class ListenerSource {
    List<Listener> listeners = new ArrayList<>();

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    public void notify(Event e){
        listeners.forEach(v->v.exc(e));
    }
}
