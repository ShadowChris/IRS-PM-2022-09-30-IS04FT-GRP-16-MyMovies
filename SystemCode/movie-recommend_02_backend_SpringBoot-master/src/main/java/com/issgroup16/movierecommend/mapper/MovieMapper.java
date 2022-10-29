package com.issgroup16.movierecommend.mapper;


import com.issgroup16.movierecommend.model.dto.MovieDTO;
import com.issgroup16.movierecommend.model.vo.MovieVO;

import java.util.List;

/**
 * @Author caizimo
 * @Date 2022/10/14 11:45
 */
public interface MovieMapper {
    boolean insertSelective(MovieVO vo);

    MovieDTO selectMovieDetailsById(String id);

    /**
     * deprecated, use selectMoviesByPage
     * @param vo
     * @return
     */
    List<MovieDTO> selectMovies(MovieVO vo);

    List<MovieDTO> selectSampleMovies(MovieVO vo);

    List<MovieDTO> selectMoviesByList(List<String> ids);

    List<MovieDTO> selectMoviesByPage(MovieVO vo, Integer limit, Integer offset);

    Integer selectMovieNum(MovieVO vo);
}
