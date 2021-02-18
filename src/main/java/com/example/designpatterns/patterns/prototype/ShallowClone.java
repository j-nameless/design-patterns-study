package com.example.designpatterns.patterns.prototype;

import java.util.List;

/**
 * className ShallowClone
 * date 2021/2/18
 *
 * @author JC
 */
public class ShallowClone implements Cloneable{
    private Test test;
    public static void main(String[] args) throws CloneNotSupportedException {
        ShallowClone ins1 = new ShallowClone();
        ins1.setTest(new ShallowClone.Test());
        ShallowClone clone = (ShallowClone) ins1.clone();
        System.out.println(ins1.getTest());
        System.out.println(clone.getTest());
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    static class Test {

    }
}
