package com.chl.springdemo.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @Author caohl
 * @Date 2023/11/22 11:51
 * @注释
 */
@Component
public class OrderService {

    @Autowired
    private UserService userService;

}
