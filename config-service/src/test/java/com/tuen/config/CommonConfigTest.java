package com.tuen.config;

import com.tuen.config.bean.CommonConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class CommonConfigTest extends BaseTest{
    @Autowired
    private CommonConfig config;

    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println(config.getPort());
        System.out.println(config.getName());
    }
}
