package com.group6.loyaltycard.api.transaction.feign.service.fallback;


import com.group6.loyaltycard.api.transaction.feign.service.TransactionPaymentFeignService;
import com.group6.loyaltycard.api.transaction.feign.service.TransactionPointsFeignService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class TransactionFeignServiceFallbackImpl implements TransactionPaymentFeignService, TransactionPointsFeignService {

    @Override
    public String helloPoints(String name) {
        return "hello " + name + ", this is lc-transaction helloPoints, but request error";
    }

    @Override
    public String helloPayment(String name) {
        return "hello " + name + ", this is lc-transaction helloPayment, but request error";
    }

    @Override
    public String addPaymentTransaction(String name) {
        return "update transaction-payment successfully.";
    }

    @Override
    public String updateCreditsTransaction(String name) {
        return "create transaction successfully.";
    }

    @Override
    public String queryPointsByUserId(@PathVariable("userId") Integer userId) {
        return "queryPointsByUserId, request error, was fused";
    }

    @Override
    public String queryOrdersByUserId(@PathVariable("userId") Integer userId) {
        return "queryOrdersByUserId, request error, was fused";
    }
}