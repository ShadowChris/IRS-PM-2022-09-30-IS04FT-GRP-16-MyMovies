package com.issgroup16.movierecommend.mapper;

import com.issgroup16.movierecommend.model.dto.UserDTO;
import com.issgroup16.movierecommend.model.vo.UserVO;
import org.apache.ibatis.annotations.Param;

/**
* @author Shadow006
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-07-30 16:28:54
* @Entity com.issgroup14.movierecommend.model.entity.User
*/
//@Mapper
public interface UserMapper {

    boolean insertSelective(UserVO vo);

    boolean updateExpiredDateBySecond(@Param("userId") Integer userId, @Param("second") int second);

    boolean updateExpiredDateByDay(@Param("userId") Integer userId, @Param("day") int day);

    UserDTO selectUserByUserId(Integer userId);



}




