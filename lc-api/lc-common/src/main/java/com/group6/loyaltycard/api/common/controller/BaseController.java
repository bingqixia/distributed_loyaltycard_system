package com.group6.loyaltycard.api.common.controller;

import com.group6.loyaltycard.api.common.utils.QueryPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Supplier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController {

    private Map<String, Object> getData(PageInfo<?> pageInfo) {
        Map<String, Object> data = new HashMap<>();
        data.put("rows", pageInfo.getList());
        data.put("total", pageInfo.getTotal());
        return data;
    }

    /**
     * Supplier is a new feature of JDK8
     * Features: Only return value, no input parameters
     * For example: Supplier<User> user = User::new.
     * No User object is constructed at this point, but a new User construct is obtained when the `user.get()` method is called
     * <p>
     * QueryPage is the entity that encapsulates the paging criteria, if not specified the default query all
     */

    public Map<String, Object> selectByPageNumSize(QueryPage page, Supplier<?> s) {
        PageHelper.startPage(page.getPageCode(), page.getPageSize());
        PageInfo<?> pageInfo = new PageInfo<>((List<?>) s.get());
        PageHelper.clearPage();
        return getData(pageInfo);
    }

}
