package com.group6.loyaltycard.api.points;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.group6.loyaltycard.api.points.dao.user")
public class PointsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointsApplication.class, args);
	}
}
