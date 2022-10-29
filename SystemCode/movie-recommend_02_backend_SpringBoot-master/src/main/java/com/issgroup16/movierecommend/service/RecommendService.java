package com.issgroup16.movierecommend.service;

import com.github.pagehelper.PageInfo;
import com.issgroup16.movierecommend.model.dto.MovieDTO;
import com.issgroup16.movierecommend.model.vo.MovieVO;

/**
 * @Author caizimo
 * @Date 2022/10/22 20:49
 */
public interface RecommendService {
    PageInfo<MovieDTO> getContentBasedRecommendation(MovieVO vo);
    PageInfo<MovieDTO> getCollaborativeFilteringRecommendation(MovieVO vo);
    PageInfo<MovieDTO> getMatrixFactorizationRecommendation(MovieVO vo);
}
