package com.example.designpatterns.patterns.command;

/**
 * @author jc
 * @version 1.0.0
 * @className CommandA
 * @description
 * @date 2021/6/1
 */
public class CommandA implements Command {

    private Receiver receiver;

    public CommandA() {
        this.receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.operate();
    }
}
