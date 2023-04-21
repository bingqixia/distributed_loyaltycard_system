package com.group6.loyaltycard.api.transaction.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group6.loyaltycard.api.transaction.feign.service.TransactionPaymentFeignService;
import com.group6.loyaltycard.api.transaction.feign.service.TransactionPointsFeignService;
import com.group6.loyaltycard.api.transaction.repository.PaymentJson;
import com.group6.loyaltycard.api.transaction.repository.TransactionJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        String jsonString = "";
        PaymentJson paymentJson = new PaymentJson(
                transaction.getOrderId(),
                transaction.getUserId(),
                transaction.getCardId(),
                transaction.getOrderTime(),
                transaction.getAmounts()
        );

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonString = objectMapper.writeValueAsString(paymentJson);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(jsonString);
        return paymentFeignService.addPaymentTransaction(jsonString);
    }
}