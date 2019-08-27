package com.yudabing.community.enums;

/**
 * @author YuBing
 * @package com.yudabing.community.enums
 * @create 2019-08-27 13:57
 * @usage
 **/
public enum NotificationStatusEnum {
    UNREAD(0), READ(1);
    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}
