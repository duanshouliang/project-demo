package com.tuen.nacos.controller;

import com.tuen.nacos.service.NacosTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class NacosController {

    @Autowired
    private NacosTestService nacosTestService;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return nacosTestService.test();
    }
}
