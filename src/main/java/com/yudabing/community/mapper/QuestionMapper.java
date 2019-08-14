package com.yudabing.community.mapper;

import com.yudabing.community.model.Question;
import com.yudabing.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @author YuBing
 * @package com.yudabing.community.mapper
 * @create 2019-08-13 16:50
 **/
@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    @Select("select * from question")
    List<Question> findAll();

    @Select("select count(*) from question")
    int getCount();

    @Select("select * from question where creator = #{id}")
    List<Question> findByUser(User user);

    @Select("select count(*) from question where creator = #{id}")
    int getCountByUser(User user);

    @Select("select * from question where id = #{id}")
    Question getQuestionById(@Param("id") Integer id);
}
