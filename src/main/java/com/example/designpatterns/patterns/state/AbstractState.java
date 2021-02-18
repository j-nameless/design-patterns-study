package com.example.designpatterns.patterns.state;

/**
 * className MissingTripAbstractState
 * date 2021/1/15
 *
 * @author JC
 */
public abstract class AbstractState implements TripState {
    @Override
    public void acquire(StateMachine machine, Object param) {
        throw new RuntimeException("this record cannot be acquired");
    }

    @Override
    public void query(StateMachine machine, Object param) {
        throw new RuntimeException("this record cannot be queried");
    }

    @Override
    public void modify(StateMachine machine, Object param) {
        throw new RuntimeException("this record cannot be modified");
    }

    @Override
    public void accept(StateMachine machine, Object param) {
        throw new RuntimeException("this record cannot be accepted");
    }

    @Override
    public void revert(StateMachine machine, Object param) {
        throw new RuntimeException("this record cannot revert");
    }

    @Override
    public void finalise(StateMachine machine, Object param) {
        throw new RuntimeException("this record cannot finalise");
    }

    @Override
    public void split(StateMachine machine, Object param) {
        throw new RuntimeException("this record cannot split");
    }
}
