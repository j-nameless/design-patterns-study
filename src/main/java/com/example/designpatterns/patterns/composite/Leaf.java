package com.example.designpatterns.patterns.composite;

/**
 * @author jc
 * @version 1.0.0
 * @className Leaf
 * @description
 * @date 2021/5/28
 */
public class Leaf implements Component {

    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void add(Component c) {

    }

    @Override
    public void remove(Component c) {

    }

    @Override
    public void operate() {
        System.out.println(name);
    }
}
