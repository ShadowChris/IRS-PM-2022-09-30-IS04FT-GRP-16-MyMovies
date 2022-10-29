package com.issgroup16.movierecommend.result;

/**
 * 响应码枚举，参考HTTP状态码的语义
 *
 * @author ronger
 */
public enum ResultCode {
    // 成功
    SUCCESS(0, "SUCCESS"),
//    // 失败
//    FAIL(400, "访问失败"),
//    // 未认证（签名错误）
//    UNAUTHORIZED(401, "签名错误"),
//    // 接口不存在
//    NOT_FOUND(404, "此接口不存在"),
    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500, "系统繁忙,请稍后再试"),
//    // 参数错误
//    INVALID_PARAM(10000, "参数错误");

    NOT_LOGIN(10001, "未登录"),
    SESSION_EXPIRED(10002, "Session过期"),
    AUTH_SERVER_BUSY(10003, "授权服务器繁忙"),
    CONNECTION_TIMEOUT(11001, "网络连接超时"),
    FORBID_CLIENT_PROXY(11002, "禁止客户端使用代理"),
    PASSWORD_ERROR(12001, "密码错误"),
    CLIENT_PARAM_NOT_MATCH(13001, "客户端参数类型不匹配");

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
