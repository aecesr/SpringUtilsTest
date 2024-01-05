package com.chl.springdemo.model;

/**
 * @version 1.0
 * @Author caohl
 * @Date 2023/12/13 17:55
 * @注释
 */
public enum TencentSecret {

    SECRET_ID("AKID440vMmCa5auEmL6oP5pWAi6QqI0nXBlG"),

    SECRET_KEY("sgP5YzPvXAiU5d5FGC1FPVWOzZzVxHUm");


    public final String value;

    TencentSecret(String value){
        this.value = value;
    }

    public  String getValue(){
        return this.value;
    }

}
