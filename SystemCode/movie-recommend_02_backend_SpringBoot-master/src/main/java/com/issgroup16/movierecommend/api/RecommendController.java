package com.issgroup16.movierecommend.api;

import com.github.pagehelper.PageInfo;
import com.issgroup16.movierecommend.model.dto.MovieDTO;
import com.issgroup16.movierecommend.model.vo.MovieVO;
import com.issgroup16.movierecommend.result.GlobalResult;
import com.issgroup16.movierecommend.result.GlobalResultGenerator;
import com.issgroup16.movierecommend.service.RecommendService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author caizimo
 * @Date 2022/10/22 20:48
 */
@RestController
@RequestMapping("/recommend")
@CrossOrigin
public class RecommendController {
    @Resource
    RecommendService recommendService;

    @PostMapping(value = "get-content-based-rec")
    public GlobalResult<PageInfo<MovieDTO>> getContentBasedRecommendation(@RequestBody MovieVO vo) {
        return GlobalResultGenerator.genSuccessResult(recommendService.getContentBasedRecommendation(vo));
    }

    @PostMapping(value = "get-collaborative-filtering-rec")
    public GlobalResult<PageInfo<MovieDTO>> getCollaborativeFilteringRecommendation(@RequestBody MovieVO vo) {
        return GlobalResultGenerator.genSuccessResult(recommendService.getCollaborativeFilteringRecommendation(vo));
    }

}
