package com.group6.loyaltycard.api.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.group6.loyaltycard.api.user.repository.UserMapper;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserMapper.User findById(Integer userId) {
        return userMapper.findById(userId);
    }

    @Override
    public List<UserMapper.User> findAll() {
        return userMapper.findAll();
    }

    @Override
    @Transactional
    public int insert(UserMapper.User user) {
        return userMapper.insert(user);
    }

    @Override
    @Transactional
    public int update(UserMapper.User user) {
        return userMapper.update(user);
    }

    @Override
    @Transactional
    public int delete(Integer userId) {
        return userMapper.delete(userId);
    }
}
