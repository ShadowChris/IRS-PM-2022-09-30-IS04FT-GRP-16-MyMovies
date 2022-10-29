package com.issgroup16.movierecommend.service;

import com.issgroup16.movierecommend.model.dto.WechatAuthDTO;

/**
 * @author caizimo
 * @date 2022/7/30 16:53
 */
public interface WechatAuthService {
    /**
     * 微信授权服务
     * @param code
     * @return
     */
    WechatAuthDTO auth(String code, String sessionId);

    /**
     * 调用微信接口，获得用户session数据
     * @return
     */
    WechatAuthDTO getJscode2Session(String code);



}
