package com.issgroup16.movierecommend;

import com.issgroup16.movierecommend.mapper.MovieMapper;
import com.issgroup16.movierecommend.mapper.RatingMapper;
import com.issgroup16.movierecommend.model.dto.MovieDTO;
import com.issgroup16.movierecommend.model.vo.MovieVO;
import com.issgroup16.movierecommend.service.RecommendService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
class MovieRecommendApplicationTests {
    @Resource
    MovieMapper movieMapper;
    @Resource
    RatingMapper ratingMapper;
    @Resource
    RecommendService recommendService;

    @Test
    void contextLoads() {
        MovieVO vo = new MovieVO();
        vo.setUserId(1);
        vo.setK("10");
        vo.setPageNum(1);
        vo.setPageSize(5);
//
//        PageInfo<MovieDTO> dto = recommendService.getContentBasedRecommendation(vo);
//        System.out.println(dto);
        List<MovieDTO> movieDTOS = movieMapper.selectMoviesByPage(vo, vo.getPageSize(), (vo.getPageNum() - 1) * vo.getPageSize());
        System.out.println();

    }

}
