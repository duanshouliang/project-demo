package com.tuen.config.controller;

import com.alibaba.fastjson.JSONObject;
import com.tuen.config.bean.CommonConfig;
import com.tuen.config.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common/config")
public class ConfigController {

    @Autowired
    private CommonConfig config;

    @GetMapping("/list")
    public Result<Object> list(){
        JSONObject obj = new JSONObject();
        obj.put("port", config.getPort());
        obj.put("name", config.getName());
        return Result.wrapSuccessfulResult(obj);
    }
}
