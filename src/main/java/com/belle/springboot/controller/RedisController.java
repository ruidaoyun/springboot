package com.belle.springboot.controller;

import com.belle.springboot.commons.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/get")
    public String get(){
        redisUtil.set ("hello","world");
        return (String) redisUtil.get ("hello");
    }
}
