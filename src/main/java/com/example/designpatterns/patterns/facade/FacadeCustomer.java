package com.example.designpatterns.patterns.facade;

/**
 * @author jc
 * @version 1.0.0
 * @className FacadeCustomer
 * @description
 * @date 2021/5/28
 */
public class FacadeCustomer {
    public void doSomething() {
        Facade facade = new Facade();
        facade.doSomething();
    }
}

class Facade {
    FacadeSubSystem01 subSystem01 = new FacadeSubSystem01();
    FacadeSubSystem02 subSystem02 = new FacadeSubSystem02();

    public void doSomething() {
        subSystem01.doSomething();
        subSystem02.doSomething();
    }
}

class FacadeSubSystem01 {
    public void doSomething() {
        System.out.println("子系统1");
    }
}

class FacadeSubSystem02 {
    public void doSomething() {
        System.out.println("子系统2");
    }
}