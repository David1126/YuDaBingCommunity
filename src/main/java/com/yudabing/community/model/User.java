package com.yudabing.community.model;

import lombok.Data;

/**
 * @author YuBing
 * @package com.yudabing.community.model
 * @create 2019-08-12 22:27
 **/
@Data
public class User {

    private int id;

    private String accountId;

    private String name;

    private String token;

    private Long gmtCreate;

    private Long gmtModified;

    private String avatarUrl;
}
