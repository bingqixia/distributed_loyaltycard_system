package com.group6.loyaltycard.api.user.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "sys_user")
public class SysUser implements Serializable {

    /**
     * Primary Key
     */
    @Id
    private Long id;

    /**
     * User Name
     */
    private String username;

    /**
     * password
     */
    private String password;

    /**
     * Phone number
     */
    private String phone;

    /**
     * avatar
     */
    private String avatar;

    /**
     * creation time
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time")
    private Date createTime;
}
