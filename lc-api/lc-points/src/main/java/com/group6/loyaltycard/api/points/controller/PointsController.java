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
    public String hello(@PathVariable String name) {
        return "hello " + name + ", this is lc-points";
    }

    @GetMapping("/query/{userId}")
    String queryPointsByUserId(@PathVariable("userId") Integer userId){
        List<PointsMapper.Credits> credits = pointsService.findByUserId(userId);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = "Not Found";
        try {
            jsonStr = objectMapper.writeValueAsString(credits);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jsonStr;
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
            PointsMapper.Credits orders = objectMapper.readValue(jsonStr, PointsMapper.Credits.class);
            pointsService.insert(orders);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "The points transaction has been inserted into the database successfully";
    }
}