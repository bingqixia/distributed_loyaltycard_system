package com.group6.loyaltycard.api.transaction.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class CreditJson {
    private Integer orderId;
    private Integer userId;
    private Integer cardId;
    private Date orderTime;
    private Integer credits;

    public CreditJson(Integer orderId, Integer userId, Integer cardId, Date orderTime, Integer credits) {
        this.orderId = orderId;
        this.userId = userId;
        this.cardId = cardId;
        this.orderTime = orderTime;
        this.credits = credits;
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

    public void setOrderTime(Date orderTime) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        this.orderTime = Timestamp.valueOf(currentDateTime);
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}
