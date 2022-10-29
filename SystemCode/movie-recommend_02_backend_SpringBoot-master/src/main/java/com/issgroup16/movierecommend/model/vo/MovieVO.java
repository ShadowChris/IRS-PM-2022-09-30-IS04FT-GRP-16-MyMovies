package com.issgroup16.movierecommend.model.vo;

import com.issgroup16.movierecommend.model.entity.Movie;
import lombok.Data;

/**
 * @Author caizimo
 * @Date 2022/10/14 11:32
 */
@Data
public class MovieVO extends Movie {
    private Integer pageNum;
    private Integer pageSize;

    private Integer userId;
    /**
     * Top k recommendation
     */
    private String k;

}
