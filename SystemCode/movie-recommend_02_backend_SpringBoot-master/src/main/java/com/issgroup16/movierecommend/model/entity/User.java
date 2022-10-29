package com.issgroup16.movierecommend.model.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author Shadow006
 * @TableName user
 */
@Data
public class User extends BaseEntity {
    /**
     * 用户唯一id，手动生成的主键
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 加密后密码
     */
    private String password;

    /**
     * md5加密用盐值
     */
    private String md5Salt;

    /**
     * 性别（女：0，男：1）
     */
    private Integer gender;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 头像url地址
     */
    private String avatarUrl;

    /**
     * 登录状态
     */
    private String sessionId;

    /**
     * 用户登录过期时间
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss", timezone = "GMT+8")
    private Date expiredDate;

    private static final long serialVersionUID = 1L;
}