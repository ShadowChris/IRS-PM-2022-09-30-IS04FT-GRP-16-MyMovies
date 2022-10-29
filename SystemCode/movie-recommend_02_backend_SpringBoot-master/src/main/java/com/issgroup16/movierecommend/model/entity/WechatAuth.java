package com.issgroup16.movierecommend.model.entity;

import lombok.Data;

/**
 * @author caizimo
 * @date 2022/8/1 22:13
 */
@Data
public class WechatAuth extends BaseEntity {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 微信平台唯一id
     */
    private String openid;
    /**
     * 后端与服务器交互的session信息
     */
    private String sessionKey;
    /**
     * 用户在微信开放平台的唯一标识符。
     */
    private String unionid;

}
