package com.yudabing.community.dto;

import lombok.Data;

/**
 * @author YuBing
 * @package com.yudabing.community.dto
 * @create 2019-08-14 20:57
 **/
@Data
public class CommentDTO {
    private int parentId;
    private String content;
    private Integer type;
}