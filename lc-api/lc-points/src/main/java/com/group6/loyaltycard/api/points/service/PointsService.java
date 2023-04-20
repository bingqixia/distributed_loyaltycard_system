package com.group6.loyaltycard.api.points.service;
import com.group6.loyaltycard.api.points.repository.PointsMapper.Credits;
import java.util.List;

/**
 * @author sheng
 * @create 2023-04-20 23:26
 */

public interface PointsService {
    Credits findByOrderId(Integer orderId);

    List<Credits> findByUserId(Integer userId);

    List<Credits> findAll();

    int insert(Credits credits);

    int update(Credits credits);

    int delete(Integer orderId);
}