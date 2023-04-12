package com.group6.loyaltycard.api.common.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonEnums {

    LOGIN_ERROR(500, "Incorrect username or password"),
    PARAM_ERROR(401, "Parameter error"),
    USER_ERROR(500, "Failed to get user information"),
    LOGOUT_ERROR(500, "Exit Failure"),
    SYSTEM_ERROR(500, "System internal error");

    private final int code;
    private final String msg;
}
