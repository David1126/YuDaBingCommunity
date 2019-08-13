package com.yudabing.community.dto;

import lombok.Data;

/**
 * @author YuBing
 * @package com.yudabing.community.dto
 * @create 2019-08-12 17:19
 **/
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
