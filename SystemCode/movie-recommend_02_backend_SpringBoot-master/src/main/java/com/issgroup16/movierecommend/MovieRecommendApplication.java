package com.issgroup16.movierecommend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.issgroup14.movierecommend.mapper")
public class MovieRecommendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRecommendApplication.class, args);
    }

}
