package com.yudabing.community.mapper;

import com.yudabing.community.model.Question;

import java.util.List;

/**
 * @author YuBing
 * @package com.yudabing.community.mapper
 * @create 2019-08-14 20:18
 **/
public interface QuestionExtMapper {

    int incView(Question record);

    int incCommentCount(Question record);

    List<Question> selectRelated(Question question);
}
