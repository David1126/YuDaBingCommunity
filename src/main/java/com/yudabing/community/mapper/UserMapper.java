package com.yudabing.community.mapper;

import com.yudabing.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author YuBing
 * @package com.yudabing.community.mapper
 * @create 2019-08-12 22:29
 **/
@Mapper
public interface UserMapper {

    @Insert("insert into user (name, account_id, token, gmt_create, gmt_modified, avatar_url) values (#{name}, #{accountId}, #{token}, #{gmtCreate}, #{gmtModified}, #{avatarUrl})")
    void insert (User user);

    @Select("select * from user where token = #{token}")
    User findByToken (@Param("token") String token);
}
