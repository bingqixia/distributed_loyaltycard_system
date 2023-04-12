package com.group6.loyaltycard.api.admin.biz.service;

import com.group6.loyaltycard.api.admin.api.entity.SysUser;
import com.group6.loyaltycard.api.common.service.BaseService;

import java.util.List;

public interface SysUserService extends BaseService<SysUser> {

    /**
     * Search user information by username
     *
     * @param username
     * @return
     */
    SysUser findByName(String username);

    /**
     * Conditional query user
     *
     * @param user
     * @return
     */
    List<SysUser> list(SysUser user);

    /**
     * Add new user
     *
     * @param user
     */
    void create(SysUser user);

    /**
     * update user
     *
     * @param user
     */
    void update(SysUser user);

    /**
     * modify password
     *
     * @param user
     */
    void changePass(SysUser user);
}
