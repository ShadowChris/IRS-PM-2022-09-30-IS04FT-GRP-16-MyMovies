package com.issgroup16.movierecommend.model.entity;

import lombok.Data;

/**
 * @Author caizimo
 * @Date 2022/10/16 18:19
 */
@Data
public class Rating extends BaseEntity {
    private String userId;
    private String movieId;
    private String rating;
    private String timestamp;
}
