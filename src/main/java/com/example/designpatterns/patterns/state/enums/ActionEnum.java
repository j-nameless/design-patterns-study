package com.example.designpatterns.patterns.state.enums;

public enum ActionEnum implements CommonEnum{

    ACQUIRE(0,"acquire"),
    QUERY(0,"query"),
    MODIFY(0,"modify"),
    ACCEPT(0,"accept"),
    REVERT(0,"revert"),
    FINALISE(0,"finalise"),
    SPLIT(0,"split");

    private final int code;
    private final String showName;

    ActionEnum(int code, String showName) {
        this.code = code;
        this.showName = showName;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getShowName() {
        return showName;
    }
}
