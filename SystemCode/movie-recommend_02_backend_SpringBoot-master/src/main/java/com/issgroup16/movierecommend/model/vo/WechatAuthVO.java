package com.issgroup16.movierecommend.model.vo;

import com.issgroup16.movierecommend.model.entity.WechatAuth;
import lombok.Data;

/**
 * @Author caizimo
 * @Date 2022/8/3 22:05
 */
@Data
public class WechatAuthVO extends WechatAuth {
    private String code;

}
