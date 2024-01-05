package com.chl.springdemo.model;

/**
 * @version 1.0
 * @Author caohl
 * @Date 2023/12/28 17:10
 * @注释
 */
public enum TestEnum {
    //
    RECEIVE(Short.valueOf("1")),
    ARRANGEMENT(Short.valueOf("2")),
    FILLING(Short.valueOf("3")),
    USE(Short.valueOf("4"));

    private final Short value;

    private TestEnum(Short value) {
        this.value = value;
    }

    public Short getValue() {
        return this.value;
    }
}
