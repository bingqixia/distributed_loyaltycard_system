package com.group6.loyaltycard.api.transaction.feign.service.fallback;


import com.group6.loyaltycard.api.transaction.feign.service.TransactionPaymentFeignService;
import com.group6.loyaltycard.api.transaction.feign.service.TransactionPointsFeignService;
import org.springframework.stereotype.Component;

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
}