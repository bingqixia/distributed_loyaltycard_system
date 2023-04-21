package com.group6.loyaltycard.api.points.repository;

import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author sheng
 * @create 2023-04-20 23:26
 */

@Mapper
public interface PointsMapper {

    @Select("SELECT * FROM credits WHERE orderId = #{orderId}")
    Credits findByOrderId(@Param("orderId") Integer orderId);

    @Select("SELECT * FROM credits WHERE userId = #{userId}")
    List<Credits> findByUserId(@Param("userId") Integer userId);

    @Select("SELECT * FROM credits")
    List<Credits> findAll();

    @Insert("INSERT INTO credits (orderId, userId, cardId, orderTime, credits) VALUES (#{orderId}, #{userId}, #{cardId}, #{orderTime}, #{credits})")
    int insert(Credits credits);

    @Update("UPDATE credits SET userId = #{userId}, cardId = #{cardId}, orderTime = #{orderTime}, credits = #{credits} WHERE orderId = #{orderId}")
    int update(Credits credits);

    @Delete("DELETE FROM credits WHERE orderId = #{orderId}")
    int delete(@Param("orderId") Integer orderId);

    class Credits {
        private Integer orderId;
        private Integer userId;
        private Integer cardId;
        private Date orderTime;
        private Integer credits;

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
}
