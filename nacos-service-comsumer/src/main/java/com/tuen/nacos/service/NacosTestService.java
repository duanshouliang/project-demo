package com.tuen.nacos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "nacos-service-provider", fallback = NacosTestServiceFallback.class, configuration = FeignConfiguration.class)
public interface NacosTestService {
    @GetMapping("/common/test")
    ResponseEntity<String> test();
}
