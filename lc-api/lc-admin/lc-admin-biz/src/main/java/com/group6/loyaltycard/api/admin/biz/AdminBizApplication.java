package com.group6.loyaltycard.api.admin.biz;

import com.group6.loyaltycard.api.admin.api.annotation.EnableSctResourceServer;
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
@MapperScan("com.group6.loyaltycard.api.admin.biz.mapper")
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class AdminBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminBizApplication.class, args);
    }
}
