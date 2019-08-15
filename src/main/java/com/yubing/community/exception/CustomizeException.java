package com.yubing.community.exception;

/**
 * @author YuBing
 * @package com.yubing.community.exception
 * @create 2019-08-14 19:25
 **/
public class CustomizeException extends RuntimeException {

    private String message;
    private Integer code;

    public CustomizeException(CustomizeErrorCodeInterface errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }


    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
