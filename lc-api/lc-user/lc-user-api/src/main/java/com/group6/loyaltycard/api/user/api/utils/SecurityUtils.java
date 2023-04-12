package com.group6.loyaltycard.api.user.api.utils;

import com.group6.loyaltycard.api.user.api.config.LoyaltyCardUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class SecurityUtils {

    /**
     * get Authentication
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * Get Users
     */
    public LoyaltyCardUser getUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return getUser(authentication);
    }

    /**
     * Get username
     *
     * @return
     */
    public String getUsername() {
        Authentication authentication = getAuthentication();
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof LoyaltyCardUser)) {
            return (String) principal;
        }
        return null;
    }

    /**
     * Get user
     */
    public LoyaltyCardUser getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof LoyaltyCardUser) {
            return (LoyaltyCardUser) principal;
        }
        return null;
    }
}
