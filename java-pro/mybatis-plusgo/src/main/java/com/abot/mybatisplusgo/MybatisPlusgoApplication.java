package com.abot.mybatisplusgo;

import com.abot.mybatisplusgo.entity.User;
import com.abot.mybatisplusgo.mapper.UserMapper;
import com.abot.mybatisplusgo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class MybatisPlusgoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusgoApplication.class, args);
    }

    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    @Override
    public void run(String... args) throws Exception {
//        List<User> users = userMapper.selectUserByIds(Arrays.asList(1L, 2L));
//        System.out.println(users);
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUsername("aaa");
        user1.setPassword("aaa");
        user1.setType(1);
        user1.setCreateTime(new Date());
        user1.setUpdateTime(new Date());
        User user2 = new User();
        user2.setId(1L);
        user2.setUsername("bbb");
        user2.setPassword("bbb");
        user2.setType(2);
        user2.setRemark("helloworld");
        user2.setCreateTime(new Date());
        user2.setUpdateTime(new Date());
        users.add(user1);
        users.add(user2);
//        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
//        wrapper.eq(User::getId,1L);
//        wrapper.eq(User::getUsername,"haha");
//        User user = userMapper.selectOne(wrapper);
//        System.out.println(user!=null?"true":"false");
//        userMapper.updateBatch(users);
//        userMapper.updateOne(user1);
        int b = userMapper.insertBatch(users);
        System.out.println(b);
    }
}
