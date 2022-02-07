package com.tuen.redis.sample.util;

import com.alibaba.fastjson.JSON;
import com.tuen.redis.sample.App;
import com.tuen.redis.sample.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
class RedisUtilsTest {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    void tryLock() {
        Boolean status = redisUtils.tryLock("duan", "shuliang", 60);
        System.out.println(status);
    }

    @Test
    void unlock() {
        boolean status = redisUtils.unlock("duan","shuliang");
        System.out.println(status);
    }

    @Test
    void get(){
//        try {
            User user = redisUtils.get("user::10");
            System.out.println(user);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
    }
    @Test
    void set(){
        User user = new User();
        user.setId(1);
        user.setAge(2);
        user.setName("段曙亮");
        redisUtils.set("shuliang", "user");
    }
}