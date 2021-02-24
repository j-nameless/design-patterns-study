package com.example.designpatterns.patterns.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * className MyMethodIntercept
 * date 2021/2/18
 *
 * @author JC
 */
public class MyMethodIntercept implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 动态代理");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib 动态代理 后置");
        return result;
    }
}
