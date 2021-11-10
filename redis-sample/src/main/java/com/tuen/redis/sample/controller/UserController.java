package com.tuen.redis.sample.controller;

import com.tuen.redis.sample.model.User;
import com.tuen.redis.sample.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger Logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;


    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public void test(){
        System.out.println("test");
        redisTemplate.opsForValue().set("shuliang", new User(1, "shuliang", 100));

        User user = (User) redisTemplate.opsForValue().get("shuliang");
        Logger.info("当前缓存内容：{}", user.toString());

    }

    @RequestMapping("/save")
    public void save(){
        userService.save(new User(10, "段曙亮", 33));
    }
    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        userService.delete(id);
    }
    @RequestMapping("/{id}")
    public void get(@PathVariable("id") Integer id){
        userService.get(id);
    }
}
