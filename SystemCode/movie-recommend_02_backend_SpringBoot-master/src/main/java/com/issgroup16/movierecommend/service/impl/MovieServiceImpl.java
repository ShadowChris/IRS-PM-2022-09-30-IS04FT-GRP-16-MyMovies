package com.issgroup16.movierecommend.service.impl;

import com.github.pagehelper.PageInfo;
import com.issgroup16.movierecommend.mapper.MovieMapper;
import com.issgroup16.movierecommend.model.dto.MovieDTO;
import com.issgroup16.movierecommend.model.vo.MovieVO;
import com.issgroup16.movierecommend.service.MovieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author caizimo
 * @Date 2022/10/14 11:45
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Resource
    MovieMapper movieMapper;

    @Override
    public PageInfo<MovieDTO> getMoviesByPage(MovieVO vo) {
        int page = vo.getPageNum();
        int rows = vo.getPageSize();
        List<MovieDTO> list = movieMapper.selectMoviesByPage(vo, rows, (page - 1) * rows);
        PageInfo<MovieDTO> pageInfo = new PageInfo<>(list);
        pageInfo.setTotal(movieMapper.selectMovieNum(vo));
        return pageInfo;
    }

    public MovieDTO getMovieDetailsById(String id) {
        return  movieMapper.selectMovieDetailsById(id);
    }
}
