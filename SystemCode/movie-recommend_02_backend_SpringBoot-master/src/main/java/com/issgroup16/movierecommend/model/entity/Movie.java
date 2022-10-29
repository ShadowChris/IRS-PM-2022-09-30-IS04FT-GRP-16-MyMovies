package com.issgroup16.movierecommend.model.entity;

import lombok.Data;

/**
 * @Author caizimo
 * @Date 2022/10/14 11:15
 */
@Data
public class Movie extends BaseEntity {
    private String id;

    private String name;

    /**
     * 电影海报url
     */
    private String url;

    /**
     * 电影时长
     */
    private String time;

    /**
     * 类别
     */
    private String genre;

    /**
     * 上映时间
     */
    private String releaseTime;

    /**
     * 详情介绍
     */
    private String intro;

    /**
     * 导演
     */
    private String directors;

    /**
     * 编剧
     */
    private String writers;

    /**
     * 电影主演
     */
    private String stars;

}
