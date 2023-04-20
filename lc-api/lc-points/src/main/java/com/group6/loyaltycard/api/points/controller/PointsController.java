package com.group6.loyaltycard.api.points.controller;

import com.group6.loyaltycard.api.points.user.UserMapper;
import com.group6.loyaltycard.api.points.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PointsController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/pc/{name}")
    public String hello(@PathVariable String name) {
        UserMapper.User user = new UserMapper.User();
        user.setUserName(name);
        user.setRegion(1);
        user.setCardId(0);
        user.setEmail("test111");
        user.setRegionName("Region111");
//        userService.insert(user);
        List<UserMapper.User> resp =  userService.findAll();

//        Logger.debug("DB Suss message, first user: " + resp.get(0).getUserName());
        return "DB Suss message first user is :" + resp.get(0).getUserName() + ", by lc-points";
//        userService.findAll();
    }

    @GetMapping("/hello/{name}")
    public String hello1(@PathVariable String name) {
        return "hello " + name + ", this is lc-points";
    }

}