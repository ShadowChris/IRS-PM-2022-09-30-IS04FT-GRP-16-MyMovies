package com.issgroup16.movierecommend.mapper;

/**
 * @Author caizimo
 * @Date 2022/10/16 18:27
 */

public interface RatingMapper {
    String selectAvgRatingByMovieId(String movieId);
}
