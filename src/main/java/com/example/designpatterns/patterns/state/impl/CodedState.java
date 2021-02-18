package com.example.designpatterns.patterns.state.impl;

import com.example.designpatterns.patterns.state.AbstractState;
import com.example.designpatterns.patterns.state.StateMachine;


/**
 * className AcquireState
 * date 2021/1/15
 *
 * @author JC
 */
public class CodedState extends AbstractState {
    @Override
    public void acquire(StateMachine machine, Object param) {
        machine.acquire(param);
    }
}
