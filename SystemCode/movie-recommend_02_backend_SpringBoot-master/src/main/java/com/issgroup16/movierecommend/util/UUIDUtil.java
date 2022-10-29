package com.issgroup16.movierecommend.util;

import java.util.UUID;

/**
 * @author caizimo
 * @date 2022/8/17 20:17
 */
public class UUIDUtil {
    public static String genUserName() {
        UUID uuid = UUID.randomUUID();
        String id = "qp_" + uuid.toString().substring(24);
        return id;
    }
}
