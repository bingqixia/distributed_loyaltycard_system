package com.group6.loyaltycard.api.admin.api.config.service;

import com.group6.loyaltycard.api.admin.api.config.LoyaltyCardUser;
import com.group6.loyaltycard.api.admin.api.entity.SysUser;
import com.group6.loyaltycard.api.admin.api.feign.RemoteUserService;
import com.group6.loyaltycard.api.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * load user data
 *
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private RemoteUserService remoteUserService;

    /**
     * Load user information
     *
     * @param username pass username value
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername >> username = {}", username);
        Result<SysUser> result = remoteUserService.info(username);
        return getUserDetails(result);
    }

    /**
     *
     * @param result
     * @return
     */
    private UserDetails getUserDetails(Result<SysUser> result) {
        if (result == null || result.getData() == null) {
            throw new UsernameNotFoundException("User does not exist");
        }
        SysUser user = result.getData();

        // List of user roles
        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList("ADMIN");

        return new LoyaltyCardUser(user.getId(), user.getUsername(), user.getPassword(), true, true, true, true, authorityList);
    }
}
