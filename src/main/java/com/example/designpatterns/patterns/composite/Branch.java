package com.example.designpatterns.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jc
 * @version 1.0.0
 * @className Branch
 * @description
 * @date 2021/5/28
 */
public class Branch implements Component {

    private String name;

    private List<Component> children = new ArrayList<>();

    public Branch(String name) {
        this.name = name;
    }

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public void operate() {
        System.out.println(name);
        children.forEach(Component::operate);
    }
}
