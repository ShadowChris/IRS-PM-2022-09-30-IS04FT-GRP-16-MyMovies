package com.issgroup16.movierecommend.api;

import com.issgroup16.movierecommend.model.dto.MovieDTO;
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
@RequestMapping("/movie")
@CrossOrigin
public class MovieController {
    @Resource
    MovieService movieService;
    @GetMapping(value = "/{id}")
    public GlobalResult<MovieDTO> queryMovieList(@PathVariable(value = "id") String id) {
        return GlobalResultGenerator.genSuccessResult(movieService.getMovieDetailsById(id));
    }


}
