package com.abot.mybatisplusgo;

import com.abot.mybatisplusgo.entity.User;
import com.abot.mybatisplusgo.mapper.UserMapper;
import com.abot.mybatisplusgo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

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
        User user = new User();
        user.setId(1L);
        user.setUsername(null);
        userService.update(user);
    }
}
