package com.issgroup16.movierecommend.model.dto;

import com.issgroup16.movierecommend.model.entity.WechatAuth;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author caizimo
 * @date 2022/8/1 22:13
 */
@Data
public class WechatAuthDTO extends WechatAuth {
    /**
     * 客户端与服务端交互的session信息
     */
    private String sessionId;

    private String errcode;

    private String errmsg;

    private String avatarUrl;


    @JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss", timezone = "GMT+8")
    private Date expiredDate;

    private String userName;

}
