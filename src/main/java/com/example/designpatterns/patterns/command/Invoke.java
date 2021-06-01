package com.example.designpatterns.patterns.command;

/**
 * @author jc
 * @version 1.0.0
 * @className Invoke
 * @description
 * @date 2021/6/1
 */
public class Invoke {
    private Command command;

    public Invoke(Command command) {
        this.command = command;
    }

    public void call() {
        command.execute();
    }
}
