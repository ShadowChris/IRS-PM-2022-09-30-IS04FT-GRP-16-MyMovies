package com.issgroup16.movierecommend.model.dto;

import com.issgroup16.movierecommend.model.entity.Movie;
import lombok.Data;

/**
 * @Author caizimo
 * @Date 2022/10/14 11:31
 */
@Data
public class MovieDTO extends Movie {
    private String rating;
}
