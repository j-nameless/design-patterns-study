package com.example.designpatterns.patterns.composite;

/**
 * @author jc
 * @version 1.0.0
 * @className Componont
 * @description
 * @date 2021/5/28
 */
public interface Component {
    void add(Component c);
    void remove(Component c);
    void operate();
}
