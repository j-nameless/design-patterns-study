package com.example.designpatterns.patterns;

import com.example.designpatterns.patterns.state.StateMachine;
import com.example.designpatterns.patterns.state.enums.ActionEnum;
import com.example.designpatterns.patterns.state.enums.StateEnum;
import com.example.designpatterns.patterns.state.utils.EnumUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class PatternsApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

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

}
