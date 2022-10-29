package com.issgroup16.movierecommend.mapper;

import com.issgroup16.movierecommend.model.dto.WechatAuthDTO;
import com.issgroup16.movierecommend.model.vo.WechatAuthVO;

/**
 * @author shadow006
 */
//@Mapper
public interface WechatAuthMapper {
    boolean insertSelective(WechatAuthVO vo);
//
//    boolean deleteWechatAuth(String userId);
//
//    WechatAuthDTO findWechatAuth(WechatAuthVO vo);

    WechatAuthDTO selectWechatAuthByOpenid(String openid);

}
