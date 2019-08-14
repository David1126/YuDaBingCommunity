package com.yubing.community.exception;

/**
 * @author YuBing
 * @package com.yubing.community.exception
 * @create 2019-08-14 19:25
 **/
public class CustomizeException extends RuntimeException {

    private String message;

    public CustomizeException(CustomizeErrorCodeInterface errorCode) {
        this.message = errorCode.getMessage();
    }


    @Override
    public String getMessage() {
        return message;
    }
}
