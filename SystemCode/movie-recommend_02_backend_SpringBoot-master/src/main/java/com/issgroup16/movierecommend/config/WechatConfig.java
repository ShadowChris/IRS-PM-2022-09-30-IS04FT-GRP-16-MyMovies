package com.issgroup16.movierecommend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author caizimo
 * @date 2022/8/1 22:01
 */
@Configuration
public class WechatConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
