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

    /**
     * 模拟Feign远程调用，这里暴露一个请求接口`/feignHello`
     * 这个请求接口将调用`AuthFeignService`（Feign接口）
     * Feign接口（`AuthFeignService`接口）将会通过`@FeignClient(value = "template-admin")`在Eureka注册中心寻找`template-admin`模块
     * Feign接口类似Controller的Rest接口，也暴露一个地址，这个地址对应`template-admin`模块的一个Controller接口地址
     *
     * @param name
     * @return
     */
    @GetMapping("/helloPoints/{name}")
    public String helloPoints(@PathVariable String name) {
        return pointsFeignService.helloPoints(name);
    }

    @GetMapping("/helloPayment/{name}")
    public String helloPayment(@PathVariable String name) {
        return paymentFeignService.helloPayment(name);
    }

//    @GetMapping("/hello")
//    public String hello(int userId, int amount) {
//
//        return "hello, userId: " + userId + "amount:" + amount + ", this is lc-transaction";
//    }

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

        List<CreditJson> credits = new ArrayList<>();

        CreditJson credit1 = new CreditJson(
                transaction.getOrderId(),
                transaction.getUserId(),
                transaction.getCardId(),
                transaction.getOrderTime(),
                transaction.getPoints().get(0)
        );
        credits.add(credit1);

        CreditJson credit2 = new CreditJson(
                transaction.getOrderId(),
                transaction.getUserId(),
                transaction.getCardId(),
                transaction.getOrderTime(),
                transaction.getPoints().get(1)
        );
        credits.add(credit2);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            paymentJsonStr = objectMapper.writeValueAsString(payment);
            creditJsonStr = objectMapper.writeValueAsString(credits);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(creditJsonStr);
        paymentFeignService.addPaymentTransaction(paymentJsonStr);
        return pointsFeignService.updateCreditsTransaction(creditJsonStr);
    }
}