package com.group6.loyaltycard.api.user.biz;

import com.group6.loyaltycard.api.user.api.annotation.EnableSctResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * System API business interface admin
 *
 */
@EnableSctResourceServer
@MapperScan("com.group6.loyaltycard.api.user.biz.mapper")
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class UserBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserBizApplication.class, args);
    }
}
