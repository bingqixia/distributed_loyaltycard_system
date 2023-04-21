package com.group6.loyaltycard.api.payment.service;

import com.group6.loyaltycard.api.payment.repository.PaymentMapper.Orders;

import java.util.List;

/**
 * @author sheng
 * @create 2023-04-20 23:26
 */

public interface PaymentService {
    Orders findByOrderId(Integer orderId);

    List<Orders> findByUserId(Integer userId);

    List<Orders> findAll();

    int insert(Orders credits);

    int update(Orders credits);

    int delete(Integer orderId);
}