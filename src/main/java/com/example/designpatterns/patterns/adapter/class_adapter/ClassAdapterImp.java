package com.example.designpatterns.patterns.adapter.class_adapter;

import org.springframework.stereotype.Component;

/**
 * @author jc
 * @version 1.0.0
 * @className AdapterImp
 * @description
 * @date 2021/5/20
 */
@Component
public class ClassAdapterImp extends Target implements ClassAdapter {
    @Override
    public void doRequest() {
        System.out.println("调用类适配器方法");
        super.targetRequest();
    }
}
