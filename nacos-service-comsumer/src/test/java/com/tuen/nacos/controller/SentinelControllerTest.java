package com.tuen.nacos.controller;

import com.tuen.nacos.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class SentinelControllerTest extends BaseTest {

    @Autowired
    private SentinelController controller;
    @Test
    void helloSentinel() {

        while (true){
            controller.helloSentinel();
        }
    }
}