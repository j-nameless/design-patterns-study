package com.example.designpatterns.patterns.state;

/**
 * className State
 * date 2021/1/15
 *
 * @author JC
 */
public interface TripState {
    void acquire(StateMachine machine, Object param);

    void query(StateMachine machine, Object param);

    void modify(StateMachine machine, Object param);

    void accept(StateMachine machine, Object param);

    void revert(StateMachine machine, Object param);

    void finalise(StateMachine machine, Object param);

    void split(StateMachine machine, Object param);
}
