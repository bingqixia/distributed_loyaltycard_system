package com.group6.loyaltycard.api.admin.api.feign;

import com.group6.loyaltycard.api.admin.api.entity.SysUser;
import com.group6.loyaltycard.api.admin.api.feign.fallback.RemoteUserServiceFallbackImpl;
import com.group6.loyaltycard.api.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * User remote call interface
 *
 */
@FeignClient(value = "lc-admin-biz", fallback = RemoteUserServiceFallbackImpl.class)
public interface RemoteUserService {

    /**
     * Find user information by username
     *
     * @return
     */
    @GetMapping("/user/info/{username}")
    Result<SysUser> info(@PathVariable("username") String username);
}
