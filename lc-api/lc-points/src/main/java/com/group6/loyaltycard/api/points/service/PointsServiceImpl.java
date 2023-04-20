package com.group6.loyaltycard.api.points.service;

import com.group6.loyaltycard.api.points.repository.PointsMapper;
import com.group6.loyaltycard.api.points.repository.PointsMapper.Credits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author sheng
 * @create 2023-04-20 23:27
 */

@Service
public class PointsServiceImpl implements PointsService {

    @Autowired
    private PointsMapper pointsMapper;

    @Override
    public Credits findByOrderId(Integer orderId) {
        return pointsMapper.findByOrderId(orderId);
    }

    @Override
    public List<Credits> findByUserId(Integer userId) {
        return pointsMapper.findByUserId(userId);
    }

    @Override
    public List<Credits> findAll() {
        return pointsMapper.findAll();
    }

    @Override
    @Transactional
    public int insert(Credits credits) {
        return pointsMapper.insert(credits);
    }

    @Override
    @Transactional
    public int update(Credits credits) {
        return pointsMapper.update(credits);
    }

    @Override
    @Transactional
    public int delete(Integer orderId) {
        return pointsMapper.delete(orderId);
    }
}
