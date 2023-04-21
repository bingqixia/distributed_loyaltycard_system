package com.group6.loyaltycard.api.payment.repository;

import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Mapper
public interface PaymentMapper {
    @Select("SELECT * FROM orders WHERE orderId = #{orderId}")
    Orders findByOrderId(@Param("orderId") Integer orderId);

    @Select("SELECT * FROM orders WHERE userId = #{userId}")
    List<Orders> findByUserId(@Param("userId") Integer userId);

    @Select("SELECT * FROM orders")
    List<Orders> findAll();

    @Insert("INSERT INTO orders (orderId, userId, cardId, orderTime, amounts) VALUES (#{orderId}, #{userId}, #{cardId}, #{orderTime}, #{amounts})")
    int insert(Orders amounts);

    @Update("UPDATE orders SET userId = #{userId}, cardId = #{cardId}, orderTime = #{orderTime}, amounts = #{amounts} WHERE orderId = #{orderId}")
    int update(Orders amounts);

    @Delete("DELETE FROM orders WHERE orderId = #{orderId}")
    int delete(@Param("orderId") Integer orderId);

    class Orders {
        private Integer orderId;
        private Integer userId;
        private Integer cardId;
        private Date orderTime;
        private Integer amounts;

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

        public Integer getAmounts() {
            return amounts;
        }

        public void setAmounts(Integer amount) {
            this.amounts = amount;
        }
    }
}
