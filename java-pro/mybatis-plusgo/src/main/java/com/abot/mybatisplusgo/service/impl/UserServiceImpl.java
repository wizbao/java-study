package com.abot.mybatisplusgo.service.impl;

import com.abot.mybatisplusgo.entity.User;
import com.abot.mybatisplusgo.mapper.UserMapper;
import com.abot.mybatisplusgo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author admin
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-06-15 14:40:41
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Boolean insertUser(User user) {
        return userMapper.insert(user) == 1;
    }

    @Override
    public void update(User user) {
        User user1 = new User();
        if (user.getId() == null) {
            throw new RuntimeException("id不能为空");
        }else {
            user1.setId(user.getId());
        }

            user1.setUsername(user.getUsername());

        userMapper.updateById(user1);
    }
}




