package com.chl.springdemo.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @version 1.0
 * @Author caohl
 * @Date 2023/11/22 11:51
 * @注释
 */
@Component
public class UserService implements InitializingBean {

    @Autowired
    private OrderService orderService;


    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Transactional(propagation = Propagation.NEVER)
    public void test() {
//        jdbcTemplate.execute();
        System.out.println(orderService);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
