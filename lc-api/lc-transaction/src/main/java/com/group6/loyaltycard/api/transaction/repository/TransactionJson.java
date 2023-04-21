package com.group6.loyaltycard.api.transaction.repository;

import java.util.Date;

public class TransactionJson {
    private Integer orderId;
    private Integer userId;
    private Integer cardId;
    private Date orderTime;
    private Integer amounts;
    private Integer points;

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date  orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getAmounts() {
        return amounts;
    }

    public void setAmounts(Integer amount) {
        this.amounts = amount;
    }
}
