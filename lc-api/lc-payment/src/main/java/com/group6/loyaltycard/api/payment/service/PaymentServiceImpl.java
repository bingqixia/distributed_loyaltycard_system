package com.group6.loyaltycard.api.payment.service;

import com.group6.loyaltycard.api.payment.repository.PaymentMapper;
import com.group6.loyaltycard.api.payment.repository.PaymentMapper.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author sheng
 * @create 2023-04-20 23:27
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Orders findByOrderId(Integer orderId) {
        return paymentMapper.findByOrderId(orderId);
    }

    @Override
    public List<Orders> findByUserId(Integer userId) {
        return paymentMapper.findByUserId(userId);
    }

    @Override
    public List<Orders> findAll() {
        return paymentMapper.findAll();
    }

    @Override
    @Transactional
    public int insert(Orders orders) {
        return paymentMapper.insert(orders);
    }

    @Override
    @Transactional
    public int update(Orders orders) {
        return paymentMapper.update(orders);
    }

    @Override
    @Transactional
    public int delete(Integer orderId) {
        return paymentMapper.delete(orderId);
    }
}
