package com.group6.loyaltycard.api.transaction.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group6.loyaltycard.api.transaction.feign.service.TransactionPaymentFeignService;
import com.group6.loyaltycard.api.transaction.feign.service.TransactionPointsFeignService;
import com.group6.loyaltycard.api.transaction.repository.CreditJson;
import com.group6.loyaltycard.api.transaction.repository.PaymentJson;
import com.group6.loyaltycard.api.transaction.repository.TransactionJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionPaymentFeignService paymentFeignService;

    @Autowired
    private TransactionPointsFeignService pointsFeignService;

    @GetMapping("/queryPoints")
    public String queryPoints(@RequestParam Integer userId) {
        return pointsFeignService.queryPointsByUserId(userId);
    }

    @GetMapping("/helloPoints/{name}")
    public String helloPoints(@PathVariable String name) {
        return pointsFeignService.helloPoints(name);
    }

    @GetMapping("/helloPayment/{name}")
    public String helloPayment(@PathVariable String name) {
        return paymentFeignService.helloPayment(name);
    }

    @GetMapping("/queryPayment")
    public String queryPayment(@RequestParam Integer userId) {
        return paymentFeignService.queryOrdersByUserId(userId);
    }

    @PostMapping("/addTransaction")
    public String addTransactionPayment(@RequestBody TransactionJson transaction) {
        String creditJsonStr = "";
        String paymentJsonStr = "";
        PaymentJson payment = new PaymentJson(
                transaction.getOrderId(),
                transaction.getUserId(),
                transaction.getCardId(),
                transaction.getOrderTime(),
                transaction.getAmounts()
        );

        CreditJson credit = new CreditJson(
                transaction.getOrderId(),
                transaction.getUserId(),
                transaction.getCardId(),
                transaction.getOrderTime(),
                transaction.getPoints()
        );

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            paymentJsonStr = objectMapper.writeValueAsString(payment);
            creditJsonStr = objectMapper.writeValueAsString(credit);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(creditJsonStr);
        paymentFeignService.addPaymentTransaction(paymentJsonStr);
        return pointsFeignService.updateCreditsTransaction(creditJsonStr);
    }
}