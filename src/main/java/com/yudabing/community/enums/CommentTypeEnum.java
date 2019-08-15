package com.yudabing.community.enums;

/**
 * @author YuBing
 * @package com.yudabing.community.enums
 * @create 2019-08-15 9:02
 **/
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);
    private Integer type;


    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (commentTypeEnum.getType() == type) {
                return true;
            }
        }
        return false;
    }
}
