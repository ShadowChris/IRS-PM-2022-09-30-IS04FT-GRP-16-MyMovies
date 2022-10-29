package com.issgroup16.movierecommend.service.impl;

import com.issgroup16.movierecommend.model.dto.UserDTO;
import com.issgroup16.movierecommend.model.vo.UserVO;
import com.issgroup16.movierecommend.service.UserService;
import com.issgroup16.movierecommend.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author Shadow006
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-07-30 16:28:54
*/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean registerByWechat(UserVO vo) {

        return userMapper.insertSelective(vo);
    }

    @Override
    public boolean updateExpiredDateBySecond(Integer userId, int second) {
        return userMapper.updateExpiredDateBySecond(userId, second);
    }

    @Override
    public boolean updateExpiredDateByDay(Integer userId, int day) {
        return userMapper.updateExpiredDateBySecond(userId, day);
    }

    @Override
    public UserDTO selectUserByUserId(Integer userId) {
        return userMapper.selectUserByUserId(userId);
    }
}




