package com.example.designpatterns.patterns.factory.simple;

import com.example.designpatterns.patterns.factory.Phone;
import com.example.designpatterns.patterns.factory.HuaWeiPhone;
import com.example.designpatterns.patterns.factory.IPhone;

/**
 * className SimpleFactory
 * date 2021/2/18
 *
 * @author JC
 */
public class SimpleFactory {

    public static Phone mackProduct(int kid) {
        switch (kid) {
            case 1:
                return new HuaWeiPhone();
            case 2:
                return new IPhone();
            default:
                return null;
        }
    }
}
