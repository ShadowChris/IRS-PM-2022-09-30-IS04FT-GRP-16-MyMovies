package com.issgroup16.movierecommend.api;

import com.github.pagehelper.PageInfo;
import com.issgroup16.movierecommend.model.dto.MovieDTO;
import com.issgroup16.movierecommend.model.vo.MovieVO;
import com.issgroup16.movierecommend.result.GlobalResult;
import com.issgroup16.movierecommend.result.GlobalResultGenerator;
import com.issgroup16.movierecommend.service.MovieService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author caizimo
 * @Date 2022/10/14 11:35
 */
@RestController
@RequestMapping("/home")
@CrossOrigin
public class HomeController {
    @Resource
    MovieService movieService;
    @PostMapping(value = "queryMovieList")
    public GlobalResult<PageInfo<MovieDTO>> queryMovieList(@RequestBody MovieVO vo) {
        return GlobalResultGenerator.genSuccessResult(movieService.getMoviesByPage(vo));
    }
}
