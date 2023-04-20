package com.group6.loyaltycard.api.points.controller;

import com.group6.loyaltycard.api.points.repository.PointsMapper;
import com.group6.loyaltycard.api.points.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PointsController {

    @Autowired
    private PointsService pointsService;

    @GetMapping("/hello/{name}")
    public String hello1(@PathVariable String name) {
        return "hello " + name + ", this is lc-points";
    }

    @PostMapping ("/addCredits")
    public String addPointsTransaction(@RequestBody PointsMapper.Credits credits) {
        pointsService.insert(credits);
        return "The points transaction has been inserted into the database successfully";
    }
}