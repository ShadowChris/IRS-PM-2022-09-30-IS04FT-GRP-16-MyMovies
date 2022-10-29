package com.issgroup16.movierecommend.request;

import lombok.Data;

/**
 * @author caizimo
 * @date 2022/10/20 23:48
 */
@Data
public class GlobalRequest<T> {
    private T data;
}
