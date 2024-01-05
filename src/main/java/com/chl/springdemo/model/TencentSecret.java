package com.chl.springdemo.model;

/**
 * @version 1.0
 * @Author caohl
 * @Date 2023/12/13 17:55
 * @注释
 */
public enum TencentSecret {

    SECRET_ID(""),

    SECRET_KEY("");


    public final String value;

    TencentSecret(String value){
        this.value = value;
    }

    public  String getValue(){
        return this.value;
    }

}
