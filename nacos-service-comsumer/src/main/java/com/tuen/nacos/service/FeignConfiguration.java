package com.tuen.nacos.service;

import org.springframework.context.annotation.Bean;

public class FeignConfiguration {
    @Bean
    public NacosTestServiceFallback fallback() {
        return new NacosTestServiceFallback();
    }
}
