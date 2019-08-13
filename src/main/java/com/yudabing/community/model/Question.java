package com.yudabing.community.model;

import lombok.Data;

/**
 * @author YuBing
 * @package com.yudabing.community.model
 * @create 2019-08-13 16:52
 **/
@Data
public class Question {

    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;

}
