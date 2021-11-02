package com.tuen.config.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration
@RefreshScope   //必须增加该注解才能实时更新配置
public class CommonConfig implements Serializable {
    @Value("${server.port}")
    private Integer port;

    @Value("${name}")
    private String name;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
