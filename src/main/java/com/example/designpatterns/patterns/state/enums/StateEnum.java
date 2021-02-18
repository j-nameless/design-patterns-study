package com.example.designpatterns.patterns.state.enums;

public enum StateEnum implements CommonEnum{
    DEFAULT(0,"default"),
    CODED(1,"coded"),
    SUBMITTED(2,"submitted"),
    QUERIED(3,"queried"),
    AMENDED(4,"amended"),
    ACCEPTED(5,"accepted"),
    FINALIZED(6,"finalized"),;

    private final int code;
    private final String showName;

    StateEnum(int code, String showName) {
        this.code = code;
        this.showName = showName;
    }


    public int getCode() {
        return code;
    }


    public String getShowName() {
        return showName;
    }

}
