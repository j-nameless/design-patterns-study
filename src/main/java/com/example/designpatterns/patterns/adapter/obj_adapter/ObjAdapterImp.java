package com.example.designpatterns.patterns.adapter.obj_adapter;

import org.springframework.stereotype.Component;

/**
 * @author jc
 * @version 1.0.0
 * @className AdapterImp
 * @description
 * @date 2021/5/20
 */
@Component
public class ObjAdapterImp implements ObjAdapter {
    private Target target;

    public ObjAdapterImp() {
        this.target = new Target();
    }

    @Override
    public void doRequest() {
        System.out.println("对象适配器调用");
        target.targetRequest();
    }
}
