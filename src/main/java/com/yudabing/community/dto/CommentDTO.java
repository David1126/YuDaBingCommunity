package com.yudabing.community.dto;

import com.yudabing.community.model.User;
import lombok.Data;

/**
 * @author YuBing
 * @package com.yudabing.community.dto
 * @create 2019-08-18 18:45
 **/

@Data
public class CommentDTO {

    private Integer id;
    private Integer parentId;
    private Integer type;
    private Integer commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
}
