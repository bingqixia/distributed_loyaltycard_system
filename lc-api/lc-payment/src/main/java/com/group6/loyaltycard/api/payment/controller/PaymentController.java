package com.group6.loyaltycard.api.payment.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.group6.loyaltycard.api.payment.repository.PaymentMapper;
import com.group6.loyaltycard.api.payment.service.PaymentService;

import java.util.List;


@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "hello " + name + ", this is lc-payment";
    }

    @GetMapping("/query/{userId}")
    String queryOrdersByUserId(@PathVariable("userId") Integer userId){
        List<PaymentMapper.Orders> orders = paymentService.findByUserId(userId);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = "Not Found";
        try {
            jsonStr = objectMapper.writeValueAsString(orders);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jsonStr;
    }


    @PostMapping("/addPayment")
    public String addPaymentTransaction(@RequestBody String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            PaymentMapper.Orders order = objectMapper.readValue(json, PaymentMapper.Orders.class);
            paymentService.insert(order);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "The payment transaction has been inserted into the database successfully";
    }

//    @PostMapping("/addPayment")
//    public String addPaymentTransaction(@RequestBody PaymentMapper.Orders orders) {
//        paymentService.insert(orders);
//        return "The payment transaction has been inserted into the database successfully";
//    }
}