package com.example.designpatterns.patterns.state;


import com.example.designpatterns.patterns.state.enums.ActionEnum;
import com.example.designpatterns.patterns.state.enums.StateEnum;

public interface StateMachine {

    void setState(StateEnum state);

    void execute(ActionEnum actionType, Object params);

    void acquire(Object param);

    void query(Object param);

    void modify(Object param);

    void accept(Object param);

    void revert(Object param);

    void finalise(Object param);

    void split(Object param);

}
