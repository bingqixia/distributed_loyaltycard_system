package com.group6.loyaltycard.api.user.service;
import com.group6.loyaltycard.api.user.repository.UserMapper;
import java.util.List;

public interface UserService {
    UserMapper.User findById(Integer userId);

    List<UserMapper.User> findAll();

    int insert(UserMapper.User user);

    int update(UserMapper.User user);

    int delete(Integer userId);
}