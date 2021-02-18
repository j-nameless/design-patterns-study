package com.example.designpatterns.patterns.state.impl;

import com.example.designpatterns.patterns.state.AbstractStateMachine;
import com.example.designpatterns.patterns.state.TripState;
import com.example.designpatterns.patterns.state.enums.ActionEnum;
import com.example.designpatterns.patterns.state.enums.StateEnum;
import com.example.designpatterns.patterns.state.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * className LocationStateMachine
 * date 2021/1/15
 *
 * @author JC
 */
@Component
@Scope("prototype")
public class LocationStateMachine extends AbstractStateMachine {

    @Autowired
    private TestService testService;

    private TripState tripState;

    private static final ConcurrentHashMap<StateEnum,TripState> stateMap;

    static {
        stateMap = new ConcurrentHashMap<>();
        stateMap.put(StateEnum.CODED, new CodedState());
        stateMap.put(StateEnum.SUBMITTED,new SubmittedState());
        stateMap.put(StateEnum.DEFAULT,new DefaultState());
        stateMap.put(StateEnum.QUERIED,new QueriedState());
        stateMap.put(StateEnum.AMENDED,new AmendedState());
        stateMap.put(StateEnum.ACCEPTED,new AcceptedState());
        stateMap.put(StateEnum.FINALIZED,new FinalisedState());
    }

    public void setState(StateEnum stateEnum){
        try {
            tripState = stateMap.get(stateEnum);
        } catch (Exception e) {
            throw new RuntimeException("this status is wrong");
        }
    }

    @Override
    public void execute(ActionEnum actionType, Object params) {
        if (tripState ==null) {
            throw new RuntimeException("this status is wrong");
        }
        if (actionType==ActionEnum.ACQUIRE) {
            tripState.acquire(this,params);
        }
    }

    @Override
    public void acquire(Object param) {
        System.out.println("call machine acquire");
        testService.changeToSubmitted();
        this.setState(StateEnum.SUBMITTED);
    }

    @Override
    public void query(Object param) {
        System.out.println("call query");
    }

    @Override
    public void modify(Object param) {
        System.out.println("call modify");
    }

    @Override
    public void accept(Object param) {
        System.out.println("call accept");
    }

    @Override
    public void revert(Object param) {
        System.out.println("call revert");
    }

    @Override
    public void finalise(Object param) {
        System.out.println("call finalise");
    }

    @Override
    public void split(Object param) {
        System.out.println("call split");
    }
}
