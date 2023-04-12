package com.group6.loyaltycard.api.user.api.annotation;

import com.group6.loyaltycard.api.user.api.config.ResourceServerConfig;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * Extended Resource Services annotation
 * <p>
 *      @Inherited
 *      @Retention(RetentionPolicy.RUNTIME)
 * </p>
 *
 */
@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@Import({ResourceServerConfig.class})
public @interface EnableSctResourceServer {
}
