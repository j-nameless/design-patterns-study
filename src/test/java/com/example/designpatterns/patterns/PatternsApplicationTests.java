package com.example.designpatterns.patterns;

import com.example.designpatterns.patterns.builder.Person;
import com.example.designpatterns.patterns.factory.Apple;
import com.example.designpatterns.patterns.factory.HuaWei;
import com.example.designpatterns.patterns.factory.abstract_factory.AbstractFactory;
import com.example.designpatterns.patterns.factory.abstract_factory.ComputerFactory;
import com.example.designpatterns.patterns.factory.abstract_factory.PhoneFactory;
import com.example.designpatterns.patterns.factory.enums.AppleEnum;
import com.example.designpatterns.patterns.factory.simple.SimpleFactory;
import com.example.designpatterns.patterns.proxy.*;
import com.example.designpatterns.patterns.state.StateMachine;
import com.example.designpatterns.patterns.state.enums.ActionEnum;
import com.example.designpatterns.patterns.state.enums.StateEnum;
import com.example.designpatterns.patterns.state.utils.EnumUtil;
import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@SpringBootTest
class PatternsApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    //状态模式
    @Test
    void transitionTest() {
        // 事件驱动状态变更
        //Coded
        StateMachine codedStateMachine = applicationContext.getBean(StateMachine.class);
        System.out.println(codedStateMachine);
        codedStateMachine.setState(EnumUtil.getEnumByCode(StateEnum.class,1));
        codedStateMachine.execute(ActionEnum.ACQUIRE,null);

        //Finalize
        StateMachine finalizeStateMachine = applicationContext.getBean(StateMachine.class);
        System.out.println(finalizeStateMachine);
        finalizeStateMachine.setState(EnumUtil.getEnumByCode(StateEnum.class,6));
        finalizeStateMachine.execute(ActionEnum.ACQUIRE,null);
    }

    //构造者模式
    @Test
    public void buildTest() {
        Person.Builder builder = new Person.Builder("man",11,"test");
        builder.setPhone(11111).setCardId("512");
        Person person = builder.buildPerson();
        System.out.println(person);
    }

    @Test
    public void factoryTest() {
        Apple simpleApple = SimpleFactory.mackProduct(AppleEnum.IPHONE);
        Apple simpleApple2 = SimpleFactory.mackProduct(AppleEnum.MAC);
        System.out.println(simpleApple.getClass().getName());
        System.out.println(simpleApple2.getClass().getName());

        AbstractFactory factory1 = new ComputerFactory();
        Apple apple1 = factory1.makeApple();
        HuaWei huaWei1 = factory1.makeHuaWei();
        System.out.println(apple1.getClass().getName());
        System.out.println(huaWei1.getClass().getName());

        AbstractFactory factory2 = new PhoneFactory();
        Apple apple2 = factory2.makeApple();
        HuaWei huaWei2 = factory2.makeHuaWei();
        System.out.println(apple2.getClass().getName());
        System.out.println(huaWei2.getClass().getName());
    }

    @Test
    public void proxyTest() {
        StaticProxy proxy = new StaticProxyImpl(new StaticActualImpl());
        proxy.print();


        StaticActualImpl staticActual = new StaticActualImpl();
        StaticProxy o = (StaticProxy) Proxy.newProxyInstance(StaticProxy.class.getClassLoader(), new Class[]{StaticProxy.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Java 动态代理");
                return method.invoke(staticActual,args);
            }
        });
        o.print();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestCglib.class);
        enhancer.setCallback(new MyMethodIntercept());
        TestCglib o1 = (TestCglib) enhancer.create();
        o1.print();
    }


}
