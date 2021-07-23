package com.example.designpatterns.patterns;

import com.example.designpatterns.patterns.adapter.class_adapter.ClassAdapter;
import com.example.designpatterns.patterns.adapter.class_adapter.ClassAdapterImp;
import com.example.designpatterns.patterns.adapter.obj_adapter.ObjAdapter;
import com.example.designpatterns.patterns.adapter.obj_adapter.ObjAdapterImp;
import com.example.designpatterns.patterns.bridge.*;
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
        // 事件驱动状态变更 code从当前单子获取
        //状态是Coded，进行acquire
        StateMachine codedStateMachine = applicationContext.getBean(StateMachine.class);
        System.out.println(codedStateMachine);
        codedStateMachine.setState(EnumUtil.getEnumByCode(StateEnum.class,1));
        codedStateMachine.execute(ActionEnum.ACQUIRE,null);

        //状态是Finalize，进行acquire
        StateMachine finalizeStateMachine = applicationContext.getBean(StateMachine.class);
        System.out.println(finalizeStateMachine);
        finalizeStateMachine.setState(EnumUtil.getEnumByCode(StateEnum.class,6));
        finalizeStateMachine.execute(ActionEnum.ACQUIRE,null);
    }

    //构造者模式
    @Test
    public void buildTest() {
        //类属性过多的时候
        /*
        在软件开发中，也存在大量类似汽车一样的复杂对象，它们拥有一系列成员属性，这些成员属性中有些是引用类型的成员对象。
        而且在这些复杂对象中，还可能存在一些限制条件，如某些属性没有赋值则复杂对象不能作为一个完整的产品使用；有些属性的赋值必须按照某个顺序，
        一个属性没有赋值之前，另一个属性可能无法赋值等

        复杂对象相当于一辆有待建造的汽车，而对象的属性相当于汽车的部件，建造产品的过程就相当于组合部件的过程。
        由于组合部件的过程很复杂，因此，这些部件的组合过程往往被“外部化”到一个称作建造者的对象里，
        建造者返还给客户端的是一个已经建造完毕的完整产品对象，而用户无须关心该对象所包含的属性以及它们的组装方式，这就是建造者模式的模式动机
         */
        Person.Builder builder = new Person.Builder("man",11,"test");
        builder.setPhone(11111).setCardId("512");
        Person person = builder.buildPerson();
        System.out.println(person);
    }

    //工厂模式
    @Test
    public void factoryTest() {
        /*
        简单工厂
        一个软件系统可以提供多个外观不同的按钮（如圆形按钮、矩形按钮、菱形按钮等）， 这些按钮都源自同一个基类，
        不过在继承基类后不同的子类修改了部分属性从而使得它们可以呈现不同的外观，如果我们希望在使用这些按钮时，
        不需要知道这些具体按钮类的名字，只需要知道表示该按钮类的一个参数，并提供一个调用方便的方法，把该参数传入方法即可返回一个相应的按钮对象
         */
        Apple simpleApple = SimpleFactory.mackProduct(AppleEnum.IPHONE);
        Apple simpleApple2 = SimpleFactory.mackProduct(AppleEnum.MAC);
        System.out.println(simpleApple.getClass().getName());
        System.out.println(simpleApple2.getClass().getName());

        /*
        抽象工厂模式
        电脑工厂生产华为和mac等多系列产品
        手机工厂生产华为和iPhone等多系列产品
         */
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
        /*
        常情况下，客户端可以通过目标类的接口访问它所提供的服务。有时，现有的类可以满足客户类的功能需要，但是它所提供的接口不一定是客户类所期望的，
        这可能是因为现有类中方法名与目标类中定义的方法名不一致等原因所导致的。
        在这种情况下，现有的接口需要转化为客户类期望的接口，这样保证了对现有类的重用。如果不进行这样的转化，
        客户类就不能利用现有类所提供的功能，适配器模式可以完成这样的转化。
         */
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
        /*
        如果一个类需要多个维度的变化，比如，手机：有品牌和颜色 两个维度的变化  使用桥接
         */
        Phone redIPhone = new IPhone(new Red());
        System.out.println(redIPhone.getInfo());
        Phone blackIPhone = new IPhone(new Black());
        System.out.println(blackIPhone.getInfo());

        Phone redMate = new Mate40(new Red());
        System.out.println(redMate.getInfo());
        Phone blackMate = new Mate40(new Black());
        System.out.println(blackMate.getInfo());

        /*
        扩展
        上诉例子中，部分特殊颜色的接口如果是第三方提供且 和当前手机接口不兼容时，可以结合适配器进行适配
         */
        SpecialColor specialRed = new SpecialRed();
        Color colorAdapter = new ColorAdapter(specialRed);
        Phone specialRedMate = new Mate40(colorAdapter);
        System.out.println(specialRedMate.getInfo());
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
        Component leaf3 = new Leaf("        树叶");
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
        /*
        在软件设计中，我们经常需要向某些对象发送请求，但是并不知道请求的接收者是谁，也不知道被请求的操作是哪个，
        我们只需在程序运行时指定具体的请求接收者即可，此时，可以使用命令模式来进行设计，
        使得请求发送者与请求接收者消除彼此之间的耦合，让对象之间的调用关系更加灵活。
        命令模式可以对发送者和接收者完全解耦，发送者与接收者之间没有直接引用关系，发送请求的对象只需要知道如何发送请求，而不必知道如何完成请求
         */
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
