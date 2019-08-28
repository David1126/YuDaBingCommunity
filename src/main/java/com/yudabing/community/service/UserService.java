package com.yudabing.community.service;

import com.yudabing.community.mapper.UserMapper;
import com.yudabing.community.model.User;
import com.yudabing.community.model.UserExample;
import com.yudabing.community.model.UserExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YuBing
 * @package com.yudabing.community.service
 * @create 2019-08-14 15:38
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(user.getAccountId());
        List<User> dbUser = userMapper.selectByExample(example);
        if (dbUser == null || dbUser.size() == 0) {
            // 插入
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        } else {
            //更新
            dbUser.get(0).setGmtModified(System.currentTimeMillis());
            dbUser.get(0).setAvatarUrl(user.getAvatarUrl());
            dbUser.get(0).setName(user.getName());
            dbUser.get(0).setToken(user.getToken());
            userMapper.updateByPrimaryKey(dbUser.get(0));
        }
    }
}
