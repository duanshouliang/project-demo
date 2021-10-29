package com.tuen.nacos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class NacosController {

    @GetMapping("/test")
    public ResponseEntity test(){
        return ResponseEntity.ok("shuliang");
    }
}
