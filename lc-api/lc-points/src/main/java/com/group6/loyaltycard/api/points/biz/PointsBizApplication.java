package com.group6.loyaltycard.api.points.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.group6.loyaltycard.api.user.api.feign")
@EnableEurekaClient
@SpringBootApplication
public class PointsBizApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointsBizApplication.class, args);
	}

}
