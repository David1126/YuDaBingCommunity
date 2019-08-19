package com.yudabing.community.mapper;

import com.yudabing.community.model.Comment;

/**
 * @author YuBing
 * @package com.yudabing.community.mapper
 * @create 2019-08-19 17:35
 **/
public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}
