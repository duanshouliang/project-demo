package com.tuen.redis.sample.controller;

import com.tuen.redis.sample.App;
import com.tuen.redis.sample.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
class UserControllerTest{

    @Autowired
    private UserController userController;

    @Test
    void test1() {
        userController.test();
    }


    @Test
    public void save(){
        userController.save();
    }
    @Test
    public void delete(){
        userController.delete(2);
    }
    @Test
    public void get(){
        userController.get(2);
    }
}