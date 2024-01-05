package com.chl.springdemo;

import com.chl.springdemo.service.UserService;
import com.tencentcloudapi.lcic.v20220817.models.AppConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@Configuration
@EnableAspectJAutoProxy
public class SpringApplication {

    public static void main(String[] args) {
//        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) annotationConfigApplicationContext.getBean("userService");
        userService.test();
    }

}
