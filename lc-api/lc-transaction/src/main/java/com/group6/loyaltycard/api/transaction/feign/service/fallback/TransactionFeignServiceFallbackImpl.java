package com.group6.loyaltycard.api.transaction.feign.service.fallback;


import com.group6.loyaltycard.api.transaction.feign.service.TransactionPaymentFeignService;
import com.group6.loyaltycard.api.transaction.feign.service.TransactionPointsFeignService;
import org.springframework.stereotype.Component;
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
        return "hello " + name + ", this is lc-transaction addPaymentTransaction, but request error";
    }

    @Override
    public String updateCreditsTransaction(String name) {
        return "hello " + name + ", this is lc-transaction updateCreditsTransaction, but request error";
    }
//    public String addPaymentTransaction(@RequestBody String json) {
//        paymentService.insert(json);
//        return "The payment transaction has been inserted into the database successfully";
//    }
}