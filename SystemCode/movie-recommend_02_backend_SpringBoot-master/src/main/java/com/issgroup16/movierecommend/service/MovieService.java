package com.issgroup16.movierecommend.service;

import com.github.pagehelper.PageInfo;
import com.issgroup16.movierecommend.model.dto.MovieDTO;
import com.issgroup16.movierecommend.model.vo.MovieVO;

/**
 * @Author caizimo
 * @Date 2022/10/14 11:44
 */
public interface MovieService {
    /**
     * 分页查询电影
     * @param vo
     * @return
     */
    PageInfo<MovieDTO> getMoviesByPage(MovieVO vo);

    /**
     * 查询电影详情
     * @param id
     * @return
     */
    MovieDTO getMovieDetailsById(String id);
}
