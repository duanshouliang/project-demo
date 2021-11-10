package com.tuen.nacos.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {

    @SentinelResource(value = "helloSentinel", blockHandler = "blockHandlerHello")
    @GetMapping("/hello")
    public String helloSentinel(){
        System.out.println("sentinel");
        return "sentinel";
    }


    public static String blockHandlerHello(BlockException e){
        System.out.println("flow is limit");
        return "flow is limit";
    }

}
