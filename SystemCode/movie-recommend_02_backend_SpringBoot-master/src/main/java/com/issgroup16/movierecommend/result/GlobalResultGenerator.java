package com.issgroup16.movierecommend.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalResultGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalResultGenerator.class);

    /**
     * normal
     * @param success
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> GlobalResult<T> genResult(boolean success, int code, T data, String message) {
        GlobalResult<T> result = GlobalResult.newInstance();
        result.setSuccess(success);
        result.setCode(code);
        result.setData(data);
        result.setMessage(message);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("generate rest result:{}", result);
        }
        return result;
    }

    /**
     * success
     * @param data
     * @param <T>
     * @return
     */
    public static <T> GlobalResult<T> genSuccessResult(T data) {

        return genResult(true,0, data, null);
    }

    /**
     * error message
     * @param message error message
     * @param <T>
     * @return
     */
    public static <T> GlobalResult<T> genErrorResult(String message) {

        return genResult(false,-1, null, message);
    }

    /**
     * error
     * @param error error enum
     * @param <T>
     * @return
     */
    public static <T> GlobalResult<T> genErrorResult(ResultCode error) {

        return genResult(false, error.getCode(), null, error.getMessage());
    }

    /**
     * success no message
     * @return
     */
    public static GlobalResult genSuccessResult() {
        return genSuccessResult(null);
    }

    /**
     * success
     * @param <T>
     * @return
     */
    public static <T> GlobalResult<T> genSuccessResult(String message) {

        return genResult(true,-1, null, message);
    }

}
