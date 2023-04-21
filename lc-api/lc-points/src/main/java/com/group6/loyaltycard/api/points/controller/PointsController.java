package com.group6.loyaltycard.api.points.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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

//    @PostMapping ("/addCredits")
//    public String addPointsTransaction(@RequestBody PointsMapper.Credits credits) {
//        pointsService.insert(credits);
//        return "The points transaction has been inserted into the database successfully";
//    }

    @PostMapping ("/updateCredits")
    public String addPointsTransaction(@RequestBody String jsonStr) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<PointsMapper.Credits> orders = objectMapper.readValue(jsonStr, new TypeReference<List<PointsMapper.Credits>>() {});
            for (PointsMapper.Credits order : orders) {
                pointsService.insert(order);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "The points transaction has been inserted into the database successfully";
    }
}