package com.issgroup16.movierecommend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.issgroup16.movierecommend.constants.RouteConstants;
import com.issgroup16.movierecommend.mapper.MovieMapper;
import com.issgroup16.movierecommend.model.dto.MovieDTO;
import com.issgroup16.movierecommend.model.vo.MovieVO;
import com.issgroup16.movierecommend.service.RecommendService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author caizimo
 * @Date 2022/10/22 20:50
 */
@Service
public class RecommendServiceImpl implements RecommendService {
    @Resource
    RestTemplate restTemplate;
    @Resource
    MovieMapper movieMapper;

    @Override
    public PageInfo<MovieDTO> getContentBasedRecommendation(MovieVO vo) {

        List<String> recommendList = restTemplate.postForObject(RouteConstants.FLASK_IP_ADDRESS + "/cb-recommend", vo, ArrayList.class);

        int page = vo.getPageNum();
        int rows = vo.getPageSize();
        PageHelper.startPage(page, rows);
        List<MovieDTO> list = movieMapper.selectMoviesByList(recommendList);
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<MovieDTO> getCollaborativeFilteringRecommendation(MovieVO vo) {
        List<String> recommendList = restTemplate.postForObject(RouteConstants.FLASK_IP_ADDRESS + "/cf-recommend", vo, ArrayList.class);

        int page = vo.getPageNum();
        int rows = vo.getPageSize();
        PageHelper.startPage(page, rows);
        List<MovieDTO> list = movieMapper.selectMoviesByList(recommendList);

        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<MovieDTO> getMatrixFactorizationRecommendation(MovieVO vo) {
        return null;
    }
}
