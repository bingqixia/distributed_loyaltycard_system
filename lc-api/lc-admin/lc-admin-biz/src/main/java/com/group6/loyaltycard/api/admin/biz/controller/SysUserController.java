package com.group6.loyaltycard.api.admin.biz.controller;

import com.group6.loyaltycard.api.admin.api.entity.SysUser;
import com.group6.loyaltycard.api.admin.api.utils.SecurityUtils;
import com.group6.loyaltycard.api.admin.biz.service.SysUserService;
import com.group6.loyaltycard.api.common.constant.enums.CommonEnums;
import com.group6.loyaltycard.api.common.controller.BaseController;
import com.group6.loyaltycard.api.common.utils.QueryPage;
import com.group6.loyaltycard.api.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "SysUserController", tags = {"User Information Management Interface"})
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * Get current user information
     *
     * @return
     */
    @GetMapping("/info")
    @ApiOperation(value = "Get current authorized user information", notes = "Must be authorized by OAuth")
    public Result<SysUser> info() {
        String username = SecurityUtils.getUsername();
        SysUser user = sysUserService.findByName(username);
        if (user == null) {
            return new Result<>(CommonEnums.USER_ERROR);
        }
        return new Result<>(user);
    }

    /**
     * Query user information by username
     *
     * @param username
     * @return
     */
    @GetMapping("/info/{username}")
    @ApiOperation(value = "Query user information by username")
    @ApiImplicitParam(name = "username", value = "username", required = true, dataType = "String")
    public Result<SysUser> info(@PathVariable("username") String username) {
        return new Result<SysUser>(sysUserService.findByName(username));
    }

    /**
     * Paging query list data, conditional query
     *
     * @param user
     * @return
     */
    @PostMapping("/list")
    @ApiOperation(value = "Paging, conditional query user list information")
    @ApiImplicitParam(name = "user", value = "Query conditions", required = true, dataType = "SysUser", paramType = "body")
    public Result<Map> list(SysUser user, QueryPage queryPage) {
        return new Result<Map>(this.selectByPageNumSize(queryPage, () -> sysUserService.list(user)));
    }


    /**
     * Query user information by ID
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Query detailed user information", notes = "id exists and is greater than 0")
    @ApiImplicitParam(name = "id", value = "user ID", required = true, dataType = "Long")
    public Result<SysUser> findById(@PathVariable Long id) {
        if (id == null || id == 0) {
            return new Result<>();
        } else {
            return new Result<>(sysUserService.selectByKey(id));
        }
    }

    /**
     * Add user information
     *
     * @param user
     * @return
     */
    @PostMapping
    @ApiOperation(value = "Add user")
    @ApiImplicitParam(name = "user", value = "User Entity Information", required = true, dataType = "SysUser", paramType = "body")
    public Result add(@RequestBody SysUser user) {
        sysUserService.create(user);
        return new Result();
    }

    /**
     * delete user information
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete users")
    @ApiImplicitParam(name = "id", value = "user ID", required = true, dataType = "Long")
    public Result delete(@PathVariable Long id) {
        sysUserService.delete(id);
        return new Result();
    }

    /**
     * update user information
     *
     * @param user
     * @return
     */
    @PutMapping("/edit")
    @ApiOperation(value = "update user info")
    @ApiImplicitParam(name = "user", value = "user profile", required = true, dataType = "SysUser", paramType = "body")
    public Result edit(@RequestBody SysUser user) {
        sysUserService.update(user);
        return new Result();
    }

    /**
     * modify user
     *
     * @param user
     * @return
     */
    @PostMapping("/changePass")
    @ApiOperation(value = "modify user")
    @ApiImplicitParam(name = "user", value = "user profile", required = true, dataType = "SysUser", paramType = "body")
    public Result changePass(@RequestBody SysUser user) {
        sysUserService.changePass(user);
        return new Result();
    }

}
