package com.group6.loyaltycard.api.points.controller;

import com.group6.loyaltycard.api.points.dao.MyDao;
import com.group6.loyaltycard.api.points.dao.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointsController {

    @GetMapping("/pc/{name}")
    public String hello(@PathVariable String name) {
        User user = new User();
        user.setUserName(name);
        user.setRegion(1);
        user.setCardId(0);
        user.setEmail("test111");
        user.setRegionName("Region111");
        MyDao dao = new MyDao();
        dao.save(user);
        return "hello " + name + ", this is lc-points";
    }

    @GetMapping("/hello/{name}")
    public String hello1(@PathVariable String name) {
        return "hello " + name + ", this is lc-points";
    }

}