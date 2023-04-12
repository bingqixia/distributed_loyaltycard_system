package com.group6.loyaltycard.api.admin.api.feign.fallback;

import com.group6.loyaltycard.api.admin.api.entity.SysUser;
import com.group6.loyaltycard.api.admin.api.feign.RemoteUserService;
import com.group6.loyaltycard.api.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RemoteUserServiceFallbackImpl implements RemoteUserService {

    @Override
    public Result<SysUser> info(String username) {
        log.error("Query user information failed, username >> {}", username);
        return null;
    }
}
