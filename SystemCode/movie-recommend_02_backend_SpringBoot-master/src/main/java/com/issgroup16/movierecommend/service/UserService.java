package com.issgroup16.movierecommend.service;


import com.issgroup16.movierecommend.model.dto.UserDTO;
import com.issgroup16.movierecommend.model.vo.UserVO;

/**
* @author Shadow006
* @description 针对表【user】的数据库操作Service
* @createDate 2022-07-30 16:28:54
*/
public interface UserService {
    boolean registerByWechat(UserVO vo);

    boolean updateExpiredDateBySecond(Integer userId, int second);

    boolean updateExpiredDateByDay(Integer userId, int day);

    UserDTO selectUserByUserId(Integer userId);

}
