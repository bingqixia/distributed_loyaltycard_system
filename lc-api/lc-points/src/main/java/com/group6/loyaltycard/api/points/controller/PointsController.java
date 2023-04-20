package com.group6.loyaltycard.api.points.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointsController {

    @GetMapping("/pc/{name}")
    public String hello(@PathVariable String name) {
        return "hello " + name + ", this is lc-points";
    }
}