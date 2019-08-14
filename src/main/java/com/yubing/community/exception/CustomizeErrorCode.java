package com.yubing.community.exception;

/**
 * @author YuBing
 * @package com.yubing.community.exception
 * @create 2019-08-14 19:32
 **/
public enum  CustomizeErrorCode implements CustomizeErrorCodeInterface {

    QUESTION_NOT_FOUND("你找到问题不在了，要不要换个试试？");

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
