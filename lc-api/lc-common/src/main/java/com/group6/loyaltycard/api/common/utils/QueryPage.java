package com.group6.loyaltycard.api.common.utils;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class QueryPage implements Serializable {

    private int pageCode; //Current page
    private int pageSize; //Number of records displayed per page
}
