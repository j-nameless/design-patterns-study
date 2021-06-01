package com.example.designpatterns.patterns;

import com.example.designpatterns.patterns.adapter.class_adapter.ClassAdapter;
import com.example.designpatterns.patterns.adapter.class_adapter.ClassAdapterImp;
import com.example.designpatterns.patterns.adapter.obj_adapter.ObjAdapter;
import com.example.designpatterns.patterns.adapter.obj_adapter.ObjAdapterImp;
import com.example.designpatterns.patterns.bridge.Black;
import com.example.designpatterns.patterns.bridge.IPhone;
import com.example.designpatterns.patterns.bridge.Phone;
import com.example.designpatterns.patterns.bridge.Red;
import com.example.designpatterns.patterns.builder.Person;
import com.example.designpatterns.patterns.chain.Handler;
import com.example.designpatterns.patterns.chain.HandlerA;
import com.example.designpatterns.patterns.chain.HandlerB;
import com.example.designpatterns.patterns.command.Command;
import com.example.designpatterns.patterns.command.CommandA;
import com.example.designpatterns.patterns.command.Invoke;
import com.example.designpatterns.patterns.composite.Branch;
import com.example.designpatterns.patterns.composite.Component;
import com.example.designpatterns.patterns.composite.Leaf;
import com.example.designpatterns.patterns.decorator.Cake;
import com.example.designpatterns.patterns.decorator.Pancake;
import com.example.designpatterns.patterns.decorator.SauceCake;
import com.example.designpatterns.patterns.facade.FacadeCustomer;
import com.example.designpatterns.patterns.factory.Apple;
import com.example.designpatterns.patterns.factory.HuaWei;
import com.example.designpatterns.patterns.factory.abstract_factory.AbstractFactory;
import com.example.designpatterns.patterns.factory.abstract_factory.ComputerFactory;
import com.example.designpatterns.patterns.factory.abstract_factory.PhoneFactory;
import com.example.designpatterns.patterns.factory.enums.AppleEnum;
import com.example.designpatterns.patterns.factory.simple.SimpleFactory;
import com.example.designpatterns.patterns.flyweight.ConcreteFlyweight;
import com.example.designpatterns.patterns.flyweight.Flyweight;
import com.example.designpatterns.patterns.flyweight.FlyweightFactory;
import com.example.designpatterns.patterns.flyweight.UnShareFlyweight;
import com.example.designpatterns.patterns.observe.Event;
import com.example.designpatterns.patterns.observe.EventListenerA;
import com.example.designpatterns.patterns.observe.EventListenerB;
import com.example.designpatterns.patterns.observe.ListenerSource;
import com.example.designpatterns.patterns.proxy.*;
import com.example.designpatterns.patterns.singleton.EnumSingleton;
import com.example.designpatterns.patterns.singleton.HungrySingleton;
import com.example.designpatterns.patterns.singleton.LazySingleton;
import com.example.designpatterns.patterns.state.StateMachine;
import com.example.designpatterns.patterns.state.enums.ActionEnum;
import com.example.designpatterns.patterns.state.enums.StateEnum;
import com.example.designpatterns.patterns.state.utils.EnumUtil;
import com.example.designpatterns.patterns.strategy.StrategyFactory;
import com.example.designpatterns.patterns.template.AbstractClass;
import com.example.designpatterns.patterns.template.ConcreteClass;
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
        //类属性过多的时候
        Person.Builder builder = new Person.Builder("man",11,"test");
        builder.setPhone(11111).setCardId("512");
        Person person = builder.buildPerson();
        System.out.println(person);
    }

    //工厂模式
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

    //代理模式
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

    //单例模式
    @Test
    public void singletonTest() {
        EnumSingleton.INSTANCE.doSomething();

        HungrySingleton.getInstance().doSomething();

        LazySingleton.getInstance().doSomething();
    }

    //适配器模式
    @Test
    public void adapterTest() {
        //类适配器
        ClassAdapter classAdapter = new ClassAdapterImp();
        classAdapter.doRequest();
        //对象适配器
        ObjAdapter objAdapter = new ObjAdapterImp();
        objAdapter.doRequest();

    }

    //桥接
    @Test
    public void bridgeTest() {
        //如果所需类有多个维度的变化，使用桥接可封装变化
        Phone redIPhone = new IPhone(new Red());
        System.out.println(redIPhone.getColor());

        Phone blackIPhone = new IPhone(new Black());
        System.out.println(blackIPhone.getColor());
    }

    //装饰
    @Test
    public void decoratorTest() {
        //java io流，装饰模式的经典案例
        Cake cake = new SauceCake(new Pancake());
        cake.getCake();
    }

    //外观
    @Test
    public void facadeTest() {
        FacadeCustomer facadeCustomer = new FacadeCustomer();
        facadeCustomer.doSomething();
    }


    //享元
    @Test
    public void flyweight() {
        Flyweight flyweight = FlyweightFactory.getFlyweight("a");

        flyweight.printInfo(new UnShareFlyweight("非共享的信息"));
    }

    //组合
    @Test
    public void compositeTest() {
        //tree[leaf,branch[leaf,leaf]]
        Component tree = new Branch("       树");
        Component leaf = new Leaf("树叶");
        Component branch = new Branch("          树枝");
        Component leaf2 = new Leaf("        树叶");
        Component leaf3 = new Leaf("                 树叶");
        tree.add(leaf);
        tree.add(branch);
        branch.add(leaf2);
        branch.add(leaf3);
        tree.operate();
    }

    //模板
    @Test
    public void templateTest() {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
    }

    //策略
    @Test
    public void strategyTest() {
        StrategyFactory.operate();
    }

    //命令
    @Test
    public void commandTest() {
        Command command = new CommandA();
        Invoke invoke = new Invoke(command);
        invoke.call();
    }

    //责任链
    @Test
    public void chainTest() {
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        handlerA.setNext(handlerB);
        handlerA.handlerRequest();
    }

    //观察者
    @Test
    public void observeTest() {
        ListenerSource source = new ListenerSource();
        source.addListener(new EventListenerA());
        source.addListener(new EventListenerB());
        Event e = new Event();
        e.setFlag(true);
        source.notify(e);
    }

}
