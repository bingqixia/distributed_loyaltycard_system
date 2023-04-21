package com.group6.loyaltycard.api.user.controller;

import com.group6.loyaltycard.api.user.repository.UserMapper;
import com.group6.loyaltycard.api.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/pc/{name}")
    public String getUser(@PathVariable String name) {
        UserMapper.User user = new UserMapper.User();
        user.setUserName(name);
        user.setRegion(1);
        user.setCardId(0);
        user.setEmail("test111");
        user.setRegionName("Region111");
//        userService.insert(user);
        List<UserMapper.User> resp =  userService.findAll();

        return "DB Suss message first user is :" + resp.get(0).getUserName() + ", by lc-points";
//        userService.findAll();
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "hello " + name + ", this is lc-user";
    }

    @PostMapping("/addUser")
    public String addPaymentTransaction(@RequestBody UserMapper.User users) {
        userService.insert(users);
        return "The user transaction has been inserted into the database successfully";
    }
}
