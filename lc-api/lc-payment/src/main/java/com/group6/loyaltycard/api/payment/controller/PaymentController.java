package com.group6.loyaltycard.api.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.group6.loyaltycard.api.payment.repository.PaymentMapper;
import com.group6.loyaltycard.api.payment.service.PaymentService;


@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/py/{name}")
    public String hello(@PathVariable String name) {
        return "hello " + name + ", this is lc-payments";
    }

    @PostMapping("/addPayment")
    public String addPaymentTransaction(@RequestBody PaymentMapper.Orders orders) {
        paymentService.insert(orders);
        return "The payment transaction has been inserted into the database successfully";
    }
}