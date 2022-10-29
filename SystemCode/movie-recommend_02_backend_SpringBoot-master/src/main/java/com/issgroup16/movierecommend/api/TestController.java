package com.issgroup16.movierecommend.api;

import com.issgroup16.movierecommend.mapper.MovieMapper;
import com.issgroup16.movierecommend.model.dto.MovieDTO;
import com.issgroup16.movierecommend.model.vo.MovieVO;
import com.issgroup16.movierecommend.result.GlobalResult;
import com.issgroup16.movierecommend.result.GlobalResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author Shadow006
 */
@RestController
@RequestMapping(value = "/test")
@CrossOrigin
public class TestController {
    @Resource
    MovieMapper movieMapper;

    @PostMapping(value = "querySample")
    public GlobalResult<List<MovieDTO>> queryMovieList(MovieVO vo) {
        return GlobalResultGenerator.genSuccessResult(movieMapper.selectSampleMovies(vo));
    }


}
